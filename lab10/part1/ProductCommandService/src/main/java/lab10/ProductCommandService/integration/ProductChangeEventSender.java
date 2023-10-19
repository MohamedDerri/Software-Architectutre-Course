package lab10.ProductCommandService.integration;

import lab10.ProductCommandService.dto.ProductDto;

public interface ProductChangeEventSender {
    void sendMessage(String action, ProductDto productDto);
}
