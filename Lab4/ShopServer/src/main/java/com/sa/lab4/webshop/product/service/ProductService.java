package com.sa.lab4.webshop.product.service;

import com.sa.lab4.webshop.product.dao.ProductRepository;
import com.sa.lab4.webshop.product.domian.Product;
import com.sa.lab4.webshop.product.domian.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);

    }

    public Product getProduct(String productNumber) {
        return productRepository.findById(productNumber).orElse(null);
    }
}
