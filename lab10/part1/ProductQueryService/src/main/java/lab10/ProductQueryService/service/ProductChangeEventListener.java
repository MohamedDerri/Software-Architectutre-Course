package lab10.ProductQueryService.service;

import lab10.ProductQueryService.dto.ProductChangeDto;

public interface ProductChangeEventListener {
    void receiveMessage(String message);
    void handleProductChange(ProductChangeDto productChangeDto);
}
