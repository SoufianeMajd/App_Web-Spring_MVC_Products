package net.soufiane; // RACINE

import net.soufiane.entities.Product;
import net.soufiane.entities.User;
import net.soufiane.repository.ProductRepository;
import net.soufiane.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AppWebSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppWebSpringMvcApplication.class, args);
    }

    // Injection de données de test au démarrage (Couche DAO testée)
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        return args -> {
            // Création des utilisateurs par défaut si la base est vide
            if (userRepository.count() == 0) {
                // Utilisateur standard
                userRepository.save(User.builder()
                        .username("user")
                        .password(passwordEncoder.encode("1234"))
                        .email("user@example.com")
                        .role("USER")
                        .build());

                // Administrateur
                userRepository.save(User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("1234"))
                        .email("admin@example.com")
                        .role("ADMIN")
                        .build());

                System.out.println("✓ Default users created: user/1234 and admin/1234");
            }

            // Création de 20 produits pour tester la pagination
            if (productRepository.count() == 0) {
                for (int i = 0; i < 20; i++) {
                    productRepository.save(Product.builder()
                            .name("Laptop_HP_" + i)
                            .price(4000 + i * 5)
                            .quantity(5 + i % 10)
                            .build());
                }
                System.out.println("✓ Sample products created");
            }
        };
    }
}