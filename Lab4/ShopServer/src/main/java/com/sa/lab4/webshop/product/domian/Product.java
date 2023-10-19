package com.sa.lab4.webshop.product.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    String productNumber;
    String name;
    double price;
    String description;
    Stock stock;
}
