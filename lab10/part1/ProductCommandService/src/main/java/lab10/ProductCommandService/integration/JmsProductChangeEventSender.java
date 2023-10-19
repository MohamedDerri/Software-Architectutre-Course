package lab10.ProductCommandService.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab10.ProductCommandService.dto.ProductChangeDto;
import lab10.ProductCommandService.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JmsProductChangeEventSender implements ProductChangeEventSender {
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(String action, ProductDto productDto) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductChangeDto productChangeDto = new ProductChangeDto(action, productDto);
            String productDtoString = objectMapper.writeValueAsString(productChangeDto);
            System.out.println("Sending a JMS message:" + productDtoString);
            jmsTemplate.convertAndSend("product-change-queue", productDtoString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
