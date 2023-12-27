package io.swagger.Product;

import java.util.List;
import java.util.Optional;
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
            if (productDetails.getTenantId() != null) {
                product.setTenantId(productDetails.getTenantId());
            }

            return productRepository.save(product);
        }).orElseThrow(() -> new IllegalArgumentException("Product not found with id " + productId));
    }

    // Delete a product by ID
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<Product> getAllProducts(Long from, Long to, Double priceFrom, Double priceTo, Long quantityFrom,
            Long quantityTo) {
        return productRepository.findProductsByCriteria(from, to, priceFrom, priceTo, quantityFrom, quantityTo);
    }
}