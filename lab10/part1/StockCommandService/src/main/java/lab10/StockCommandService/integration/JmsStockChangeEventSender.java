package lab10.StockCommandService.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab10.StockCommandService.dto.StockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JmsStockChangeEventSender implements StockChangeEventSender{
    private final JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(StockDto stockDto) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String stockDtoString = objectMapper.writeValueAsString(stockDto);
            System.out.println("Sending a JMS message:" + stockDtoString);
            jmsTemplate.convertAndSend("stock-change-queue", stockDtoString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
