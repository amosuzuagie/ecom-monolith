package com.app.ecom.repository;

import com.app.ecom.dto.ProductResponse;
import com.app.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByActiveTrue();

    @Query("""
            SELECT p FROM products p
            WHERE p.active = true AND p.stockQuantity > 0
            AND LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
            """)
    List<Product> searchProduct(@Param("keyword") String keyword);
}
