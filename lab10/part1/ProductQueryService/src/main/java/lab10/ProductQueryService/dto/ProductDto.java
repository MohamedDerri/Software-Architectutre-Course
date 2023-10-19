package lab10.ProductQueryService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int productNumber;
    private String name;
    private double price;
    private int numberInStock;
}
