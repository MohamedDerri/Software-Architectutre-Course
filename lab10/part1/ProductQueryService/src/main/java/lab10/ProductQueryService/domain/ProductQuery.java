package lab10.ProductQueryService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductQuery {
    @Id
    private int productNumber;
    private String name;
    private double price;
    private int numberInStock;

}
