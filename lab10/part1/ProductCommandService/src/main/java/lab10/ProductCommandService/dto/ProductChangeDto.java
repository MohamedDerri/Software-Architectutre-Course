package lab10.ProductCommandService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductChangeDto {
    private String action;
    private ProductDto productDto;
}
