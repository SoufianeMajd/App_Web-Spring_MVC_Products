package net.soufiane; // RACINE

import net.soufiane.entities.Product;
import net.soufiane.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppWebSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppWebSpringMvcApplication.class, args);
    }

    // Injection de données de test au démarrage (Couche DAO testée)
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            // Création de 20 produits pour tester la pagination
            for (int i = 0; i < 20; i++) {
                productRepository.save(Product.builder()
                        .name("Laptop_HP_" + i)
                        .price(4000 + i*5)
                        .quantity(5 + i % 10)
                        .build());
            }
        };
    }
}