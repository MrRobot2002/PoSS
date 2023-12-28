package io.swagger.Product;

import io.swagger.Tenant.Tenant;
import io.swagger.Tenant.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@RestController
public class ProductApiController implements ProductApi {

    private final ProductService productService;
    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<Product> createProduct(io.swagger.Product.CreateProduct createProductDTO) {
        Product product = convertToEntity(createProductDTO);
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }


    @Override
    public ResponseEntity<Product> deleteProduct(Long productId) {
        try {
            // Call the service to delete the product by ID
            productService.deleteProduct(productId);

            // Return an appropriate response
            // HttpStatus.NO_CONTENT indicates that the action was successful but there's no
            // content to return.
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            // If the product doesn't exist, you might want to return a 404 Not Found.
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // For other exceptions, you might return a 500 Internal Server Error
            // Log the exception for debugging purposes
            // (Make sure to import the necessary Logger at the beginning of your class)
            System.err.println("Error occurred while trying to delete product: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Product> getProduct(@PathVariable("productId") Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @Override
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long id,
                                                 @RequestBody Product product) {
        try {
            Product updatedProduct = productService.updateProduct(id, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    private Product convertToEntity(CreateProduct createProductDTO) {
        Product product = new Product();
        product.setName(createProductDTO.getName());
        product.setQuantity(createProductDTO.getQuantity());
        product.setPrice(createProductDTO.getPrice());
        product.setTenantId(createProductDTO.getTenantId());
        return product;
    }
}