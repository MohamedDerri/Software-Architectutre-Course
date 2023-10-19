package miu.lab7.product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("STOCKSERVICE")
public interface StockServiceFeignClient {
    @GetMapping("/stocks/{productNumber}")
    public int getStock(@PathVariable String productNumber);
}
