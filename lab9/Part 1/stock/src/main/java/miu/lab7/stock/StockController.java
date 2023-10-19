package miu.lab7.stock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @GetMapping("/{productNumber}")
    public int getStock(@PathVariable String productNumber){
        return 5;
    }

}
