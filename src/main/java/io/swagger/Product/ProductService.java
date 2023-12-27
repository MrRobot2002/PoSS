package io.swagger.Product;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======
import org.springframework.data.domain.Pageable;
import io.swagger.Tenant.Tenant;
import io.swagger.Tenant.TenantRepository;
>>>>>>> 02b85579cedf445c0ddc9e7d6c14716460bcd653

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
<<<<<<< HEAD
            if (productDetails.getTenantId() != null) {
                product.setTenantId(productDetails.getTenantId());
=======

            // Handling Tenant relationship
            if (productDetails.getTenant() != null) {
                Tenant tenant = tenantRepository.findById(productDetails.getTenant().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Tenant not found"));
                product.setTenant(tenant);
>>>>>>> 02b85579cedf445c0ddc9e7d6c14716460bcd653
            }

            return productRepository.save(product);
        }).orElseThrow(() -> new IllegalArgumentException("Product not found with id " + productId));
    }

    // Delete a product by ID
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

<<<<<<< HEAD
    public List<Product> getAllProducts(Long from, Long to, Double priceFrom, Double priceTo, Long quantityFrom,
            Long quantityTo) {
        return productRepository.findProductsByCriteria(from, to, priceFrom, priceTo, quantityFrom, quantityTo);
=======
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
>>>>>>> 02b85579cedf445c0ddc9e7d6c14716460bcd653
    }
}