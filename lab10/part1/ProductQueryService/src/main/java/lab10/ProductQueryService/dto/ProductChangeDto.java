package lab10.ProductQueryService.dto;

import lombok.Data;

@Data
public class ProductChangeDto {
    private String action;
    private ProductDto productDto;
}
