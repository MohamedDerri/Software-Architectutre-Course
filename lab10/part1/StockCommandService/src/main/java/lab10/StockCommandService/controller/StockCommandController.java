package lab10.StockCommandService.controller;

import lab10.StockCommandService.dto.StockDto;
import lab10.StockCommandService.service.StockCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockCommandController {
	
    private StockCommandService stockCommandService;

    @PostMapping
    public ResponseEntity<?> addStock(@RequestBody StockDto stockDto) {
        stockCommandService.addStock(stockDto);
        return new ResponseEntity<>("Stock added", HttpStatus.OK);
    }

    @PutMapping("{/productNumber}")
    public ResponseEntity<?> udpateStock(@PathVariable int productNumber, @RequestBody StockDto stockDto) {
        stockCommandService.updateStock(productNumber, stockDto);
        return new ResponseEntity<>("Stock udpated", HttpStatus.OK);
    }

    @DeleteMapping("{/productNumber}")
    public ResponseEntity<?> deleteStock(@PathVariable int productNumber) {
        stockCommandService.deleteStock(productNumber);
        return new ResponseEntity<>("Stock deleted", HttpStatus.OK);
    }

}
