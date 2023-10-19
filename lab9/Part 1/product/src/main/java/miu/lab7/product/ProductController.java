package miu.lab7.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private StockServiceFeignClient stockService;

    @GetMapping("/{productNumber}")
    public Product getProductByProductNumber(@PathVariable String productNumber){
        int numberOnStock = stockService.getStock(productNumber);
        return new Product(productNumber, "Product" + productNumber, numberOnStock);
    }

}
