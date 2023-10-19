package lab10.ProductQueryService.dto;

import lombok.Data;

@Data
public class StockChangeDto {
    private int productNumber;
    private int quantity;
}
