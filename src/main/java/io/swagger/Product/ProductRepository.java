package io.swagger.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
        @Query("SELECT p FROM Product p WHERE " +
                        "(:from IS NULL OR p.id >= :from) AND " +
                        "(:to IS NULL OR p.id <= :to) AND " +
                        "(:priceFrom IS NULL OR p.price.amount >= :priceFrom) AND " +
                        "(:priceTo IS NULL OR p.price.amount <= :priceTo) AND " +
                        "(:quantityFrom IS NULL OR p.quantity >= :quantityFrom) AND " +
                        "(:quantityTo IS NULL OR p.quantity <= :quantityTo)")
        List<Product> findProductsByCriteria(@Param("from") Long from,
                        @Param("to") Long to,
                        @Param("priceFrom") Double priceFrom,
                        @Param("priceTo") Double priceTo,
                        @Param("quantityFrom") Long quantityFrom,
                        @Param("quantityTo") Long quantityTo);
}
