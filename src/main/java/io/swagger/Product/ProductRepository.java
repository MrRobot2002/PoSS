package io.swagger.Product;

<<<<<<< HEAD
import java.util.List;
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
>>>>>>> 02b85579cedf445c0ddc9e7d6c14716460bcd653

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

    @Query("SELECT p FROM Product p WHERE " +
            "(:priceFrom IS NULL OR p.price.amount >= :priceFrom) AND " +
            "(:priceTo IS NULL OR p.price.amount <= :priceTo) AND " +
            "(:quantityFrom IS NULL OR p.quantity >= :quantityFrom) AND " +
            "(:quantityTo IS NULL OR p.quantity <= :quantityTo)")
    Page<Product> findProductsByCriteria(@Param("priceFrom") Double priceFrom,
            @Param("priceTo") Double priceTo,
            @Param("quantityFrom") Long quantityFrom,
            @Param("quantityTo") Long quantityTo,
            Pageable pageable);
}
