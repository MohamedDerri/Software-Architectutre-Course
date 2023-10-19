package lab10.ProductQueryService.service;

import java.util.Optional;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lab10.ProductQueryService.domain.ProductQuery;
import lab10.ProductQueryService.dto.StockChangeDto;
import lab10.ProductQueryService.repository.ProductQueryRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JmsStockChangeEventListener implements StockChangeEventListener{
    private final ProductQueryRepository productQueryRepository;

    @Override
    @JmsListener(destination = "stock-change-queue")
    public void receiveMessage(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            StockChangeDto stockChangeDto = objectMapper.readValue(message, StockChangeDto.class);
            System.out.println("JMS receiver received message:" + stockChangeDto);
            handleStockChange(stockChangeDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleStockChange(StockChangeDto stockChangeDto) {
        Optional<ProductQuery> optionalProduct = productQueryRepository.findById(stockChangeDto.getProductNumber());
        if(optionalProduct.isPresent()){
            ProductQuery product = optionalProduct.get();
            product.setNumberInStock(stockChangeDto.getQuantity());
            System.out.println("Updating stock: " + product.getProductNumber() + " , quantity = "+stockChangeDto.getQuantity());
            productQueryRepository.save(product);
        }
    }
}
