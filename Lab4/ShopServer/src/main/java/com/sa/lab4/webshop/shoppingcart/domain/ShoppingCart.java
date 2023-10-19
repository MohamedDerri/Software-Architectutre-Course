package com.sa.lab4.webshop.shoppingcart.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShoppingCart {
    @Id
    int cartId;
    List<CartLine> cartLineList = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        for (CartLine line : cartLineList) {
            if (line.getProduct().getProductNumber().equals(product.getProductNumber())) {
                line.setQuantity(line.getQuantity() + quantity);
                return;
            }
        }
        CartLine line = new CartLine();
        line.setProduct(product);
        line.setQuantity(quantity);
        cartLineList.add(line);
    }
}
