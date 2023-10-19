package lab10.ProductQueryService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab10.ProductQueryService.domain.ProductQuery;
import lab10.ProductQueryService.dto.ProductChangeDto;
import lab10.ProductQueryService.repository.ProductQueryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JmsProductChangeEventListener implements ProductChangeEventListener{
    private final ProductQueryRepository productQueryRepository;
    private final ModelMapper modelMapper;

    @Override
    @JmsListener(destination = "product-change-queue")
    public void receiveMessage(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductChangeDto productChangeDto = objectMapper.readValue(message, ProductChangeDto.class);
            System.out.println("JMS receiver received message:" + productChangeDto);
            handleProductChange(productChangeDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleProductChange(ProductChangeDto productChangeDto) {
        String action = productChangeDto.getAction();
        ProductQuery product = modelMapper.map(productChangeDto.getProductDto(), ProductQuery.class);
        switch (action) {
            case "add":
                productQueryRepository.save(product);
                break;
            case "delete":
                productQueryRepository.deleteById(product.getProductNumber());
                break;
            case "update":
                Optional<ProductQuery> optionalProduct = productQueryRepository.findById(product.getProductNumber());
                if (optionalProduct.isPresent()) {
                    ProductQuery savedProduct = optionalProduct.get();
                    product.setNumberInStock(savedProduct.getNumberInStock());
                }
                productQueryRepository.save(product);
                break;
        }
    }
}
