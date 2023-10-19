package com.sa.lab4.webshop.shoppingcart.domain.dto;

import lombok.Data;

@Data
public class AddToCartDto {
    int cartId;
    String productNumber;
    int quantity;
}
