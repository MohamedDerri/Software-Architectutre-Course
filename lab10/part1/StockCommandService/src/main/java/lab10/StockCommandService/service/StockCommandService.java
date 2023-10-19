package lab10.StockCommandService.service;

import lab10.StockCommandService.dto.StockDto;

public interface StockCommandService {
    void addStock(StockDto stockDto);
    void deleteStock(int productNumber);
    void updateStock(int productNumber, StockDto stockDto);
}
