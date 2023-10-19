package com.sa.lab4.webshop.product.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Data
public class Stock {
    int quantity;
    String locationCode;
}
