package miu.lab7.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String productNumber;
    private String name;
    private int numberOnStock;
}
