package lab10.StockCommandService.integration;

import lab10.StockCommandService.dto.StockDto;

public interface StockChangeEventSender {
    void sendMessage(StockDto stockDto);
}
