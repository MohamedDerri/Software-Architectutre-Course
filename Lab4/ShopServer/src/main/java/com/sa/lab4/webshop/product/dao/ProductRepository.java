package com.sa.lab4.webshop.product.dao;

import com.sa.lab4.webshop.product.domian.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
