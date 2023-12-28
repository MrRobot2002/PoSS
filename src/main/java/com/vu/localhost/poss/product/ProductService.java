package com.vu.localhost.poss.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    // Create a new customer
    public Product createProduct(Product product) {
        // Additional business logic can be added here
        return productRepository.save(product);
    }

    // Update a product's information
    public Product updateProduct(Long productId, Product productDetails) {
        return productRepository.findById(productId).map(product -> {
            if (productDetails.getName() != null) {
                product.setName(productDetails.getName());
            }
            if (productDetails.getQuantity() != null) {
                product.setQuantity(productDetails.getQuantity());
            }
            if (productDetails.getPrice() != null) {
                product.setPrice(productDetails.getPrice());
            }
            if (productDetails.getTenantId() != null) {
                product.setTenantId(productDetails.getTenantId());
            }

            return productRepository.save(product);
        }).orElseThrow(() -> new IllegalArgumentException("product not found with id " + productId));
    }

    // Delete a product by ID
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<Product> getAllProducts(Integer page, Integer limit, Double priceFrom, Double priceTo,
            Long quantityFrom,
            Long quantityTo) {
        // Default values if null
        int pageNumber = (page != null) ? page - 1 : 0; // default to first page
        int pageSize = (limit != null) ? limit : 10; // default limit if not provided
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Product> productPage = productRepository.findProductsByCriteria(priceFrom, priceTo, quantityFrom,
                quantityTo, pageable);
        return productPage.getContent();
    }
}