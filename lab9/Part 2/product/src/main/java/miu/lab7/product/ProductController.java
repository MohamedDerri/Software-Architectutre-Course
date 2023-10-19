package miu.lab7.product;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private StockServiceFeignClient stockService;

    @GetMapping("/{productNumber}")
    @HystrixCommand(fallbackMethod = "getTextFallback")
    public ResponseEntity<?> getProductByProductNumber(@PathVariable String productNumber){
        int numberOnStock = stockService.getStock(productNumber);
        Product response = new Product(productNumber, "Product" + productNumber, numberOnStock);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<?> getTextFallback(String productNumber) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Circuit breaker: stock service is not responding or is taking too long to respond.");
    }

}
