package com.vu.localhost.poss.product.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vu.localhost.poss.product.model.Product;
import com.vu.localhost.poss.product.model.ProductRequestDTO;
import com.vu.localhost.poss.product.repository.ProductRepository;

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

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, ProductRequestDTO productDetails) {
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

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<Product> getAllProducts(Integer page, Integer limit, BigDecimal priceFrom, BigDecimal priceTo,
            Long quantityFrom,
            Long quantityTo) {
        int pageNumber = (page != null) ? page - 1 : 0;
        int pageSize = (limit != null) ? limit : 10;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Product> productPage = productRepository.findProductsByCriteria(priceFrom, priceTo, quantityFrom,
                quantityTo, pageable);
        return productPage.getContent();
    }
}