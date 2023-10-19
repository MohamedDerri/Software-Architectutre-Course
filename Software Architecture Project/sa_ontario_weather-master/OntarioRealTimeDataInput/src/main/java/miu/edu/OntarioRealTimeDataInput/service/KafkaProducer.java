package miu.edu.OntarioRealTimeDataInput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("stream-input", message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.println("Message sent to topic: {} " + message);
                    } else {
                        System.out.println("Failed to send message " + ex);
                    }
                });
    }

}
