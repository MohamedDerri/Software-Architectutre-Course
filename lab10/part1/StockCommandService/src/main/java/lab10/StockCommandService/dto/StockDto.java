package lab10.StockCommandService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockDto {
    private int productNumber;
    private int quantity;
}
