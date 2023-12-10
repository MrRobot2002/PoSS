package io.swagger.controller;

import io.swagger.api.ProductsApi;
import io.swagger.model.Product;
import io.swagger.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("myProductsController")

public class MyProductsApiController implements ProductsApi {

    private final ProductService productService;

    @Autowired
    public MyProductsApiController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<Product> getProductInOrder(Long productID) {
        Product product = productService.getProductById(productID);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<Product>> listProducts(String category, String priceRange) {
        List<Product> products = productService.listAllProducts();
        return ResponseEntity.ok(products);
    }


}
