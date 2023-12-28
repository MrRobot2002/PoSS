package com.vu.localhost.poss.product.repository;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vu.localhost.poss.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
        @Query("SELECT p FROM Product p WHERE " +
                        "(:priceFrom IS NULL OR p.price.amount >= :priceFrom) AND " +
                        "(:priceTo IS NULL OR p.price.amount <= :priceTo) AND " +
                        "(:quantityFrom IS NULL OR p.quantity >= :quantityFrom) AND " +
                        "(:quantityTo IS NULL OR p.quantity <= :quantityTo)")
        Page<Product> findProductsByCriteria(@Param("priceFrom") BigDecimal priceFrom,
                        @Param("priceTo") BigDecimal priceTo,
                        @Param("quantityFrom") Long quantityFrom,
                        @Param("quantityTo") Long quantityTo,
                        Pageable pageable);
}