package io.swagger.Product;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import io.swagger.Tenant.Tenant;
import io.swagger.Tenant.TenantRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    // Retrieve all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Create a new customer
    public Product createProduct(Product product) {
        // Additional business logic can be added here
        return productRepository.save(product);
    }

    // Update a product's information
    public Product updateProduct(Long productId, CreateProduct productDetails) {
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

            // Handling Tenant relationship
            if (productDetails.getTenant() != null) {
                Tenant tenant = tenantRepository.findById(productDetails.getTenant())
                        .orElseThrow(() -> new EntityNotFoundException("Tenant not found"));
                product.setTenant(tenant);
            }

            return productRepository.save(product);
        }).orElseThrow(() -> new IllegalArgumentException("Product not found with id " + productId));
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