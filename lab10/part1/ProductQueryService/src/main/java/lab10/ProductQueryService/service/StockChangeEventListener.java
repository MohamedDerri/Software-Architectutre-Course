package lab10.ProductQueryService.service;

import lab10.ProductQueryService.dto.StockChangeDto;

public interface StockChangeEventListener {
    void receiveMessage(String message);
    void handleStockChange(StockChangeDto stockChangeDto);
}
