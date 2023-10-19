package com.sa.lab4.webshop.shoppingcart.dao;

import com.sa.lab4.webshop.shoppingcart.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, Integer> {
}
