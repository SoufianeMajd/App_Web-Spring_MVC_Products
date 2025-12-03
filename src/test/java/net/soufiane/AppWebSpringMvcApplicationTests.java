package net.soufiane;

import net.soufiane.entities.Product;
import net.soufiane.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppWebSpringMvcApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testProductRepository() {
        Product product = Product.builder()
                .name("Test Product")
                .price(1234)
                .quantity(10)
                .build();
        productRepository.save(product);

        Long id = product.getId();
        Assertions.assertNotNull(id, "Product ID should not be null after save");

        Product found = productRepository.findById(id).orElse(null);
        Assertions.assertNotNull(found, "Product should be found in database");
        Assertions.assertEquals("Test Product", found.getName());
    }

}
