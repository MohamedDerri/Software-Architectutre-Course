package com.sa.lab4.webshop.controllers;

import com.sa.lab4.webshop.product.domian.Product;
import com.sa.lab4.webshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{productNumber}")
    public ResponseEntity<?> getProduct(@PathVariable String productNumber) {
        Product product = productService.getProduct(productNumber);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

}
