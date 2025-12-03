package net.soufiane.repository;

import net.soufiane.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Méthode pour la recherche et la pagination
    Page<Product> findByNameContainingIgnoreCase(String kw, Pageable pageable);
}