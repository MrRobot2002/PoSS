package com.vu.localhost.poss.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vu.localhost.poss.product.model.Product;
import com.vu.localhost.poss.product.model.ProductRequestDTO;
import com.vu.localhost.poss.product.service.ProductService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ProductApiController implements ProductApi {

    private static final Logger log = LoggerFactory.getLogger(ProductApiController.class);
    private final ProductService productService;

    @Autowired
    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<Product> createProduct(ProductRequestDTO createProductDTO) {
        Product product = convertToEntity(createProductDTO);
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @Override
    public ResponseEntity<Product> deleteProduct(Long productId) {
        try {
            productService.deleteProduct(productId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Error occurred while trying to delete product: ", e);
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
            @RequestBody ProductRequestDTO product) {
        try {
            Product updatedProduct = productService.updateProduct(id, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    private Product convertToEntity(ProductRequestDTO createProductDTO) {
        Product product = new Product();
        product.setName(createProductDTO.getName());
        product.setQuantity(createProductDTO.getQuantity());
        product.setPrice(createProductDTO.getPrice());
        product.setTenantId(createProductDTO.getTenantId());
        return product;
    }

    @Override
    public ResponseEntity<List<Product>> listAllProducts(
            @Parameter(in = ParameterIn.QUERY, description = "Page number (pagination)", schema = @Schema()) @Valid @RequestParam(value = "page", required = false) Integer page,
            @Parameter(in = ParameterIn.QUERY, description = "Page size (pagination)", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by price range", schema = @Schema()) @Valid @RequestParam(value = "priceFrom", required = false) BigDecimal priceFrom,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by price range", schema = @Schema()) @Valid @RequestParam(value = "priceTo", required = false) BigDecimal priceTo,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by stock level", schema = @Schema()) @Valid @RequestParam(value = "quantityFrom", required = false) Long quantityFrom,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by stock level", schema = @Schema()) @Valid @RequestParam(value = "quantityTo", required = false) Long quantityTo) {
        try {
            List<Product> products = productService.getAllProducts(page, limit, priceFrom, priceTo, quantityFrom,
                    quantityTo);
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}