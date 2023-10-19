package com.sa.lab4.webshop.controllers;

import com.sa.lab4.webshop.shoppingcart.domain.ShoppingCart;
import com.sa.lab4.webshop.shoppingcart.domain.dto.AddToCartDto;
import com.sa.lab4.webshop.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping
    public ResponseEntity<?> addToCart(@RequestBody AddToCartDto addToCartDto) {
        shoppingCartService.addToCart(addToCartDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<?> getCart(@PathVariable int cartId) {
        ShoppingCart cart = shoppingCartService.getCart(cartId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

}
