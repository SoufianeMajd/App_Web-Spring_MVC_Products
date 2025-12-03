package net.soufiane.web;

import jakarta.validation.Valid;
import net.soufiane.entities.Product;
import net.soufiane.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/index")
    public String index(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "7") int size,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {

        // Récupération des produits avec recherche et pagination
        Page<Product> pageProducts = productRepository.findByNameContainingIgnoreCase(keyword,
                PageRequest.of(page, size));

        model.addAttribute("listProducts", pageProducts.getContent());
        model.addAttribute("pages", new int[pageProducts.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "products"; // Renvoie la vue products.html
    }

    @GetMapping("/deleteProduct")
    public String delete(Long id, String keyword, int page) {
        productRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/formProduct")
    public String formProduct(Model model) {
        model.addAttribute("product", new Product());
        return "formProduct"; // Pour l'ajout d'un nouveau produit
    }

    @GetMapping("/editProduct")
    public String editProduct(Model model, Long id, String keyword, int page) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        model.addAttribute("product", product);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editProduct"; // Pour l'édition
    }

    @GetMapping("/detailsProduct")
    public String detailsProduct(Model model, Long id, String keyword, int page) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        model.addAttribute("product", product);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "detailsProduct";
    }

    @GetMapping("/save")
    public String saveGet() {
        return "redirect:/formProduct";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid Product product, BindingResult bindingResult,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "") String keyword) {

        if (bindingResult.hasErrors()) {
            // Si l'ID est présent (édition), on retourne à editProduct, sinon à formProduct
            // (ajout)
            if (product.getId() != null) {
                model.addAttribute("page", page);
                model.addAttribute("keyword", keyword);
                return "editProduct";
            }
            return "formProduct";
        }

        productRepository.save(product);

        // Redirection vers la liste
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "notAuthorized";
    }
}