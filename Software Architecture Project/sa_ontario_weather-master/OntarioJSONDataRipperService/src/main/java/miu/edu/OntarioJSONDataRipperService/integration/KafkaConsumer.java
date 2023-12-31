package miu.edu.OntarioJSONDataRipperService.integration;

import miu.edu.OntarioJSONDataRipperService.domain.OntarioEnergy;
import miu.edu.OntarioJSONDataRipperService.service.ConvertObjectToString;
import miu.edu.OntarioJSONDataRipperService.service.ConvertStringToObject;
import miu.edu.OntarioJSONDataRipperService.service.Sender;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumer {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${spring.kafka.consumer.auto-offset-reset.group-id}")
    private String groupId;

    @Autowired
    private Sender sender;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                groupId);
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @KafkaListener(topics = "stream-output")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message from Kafka stream: " + message);
        OntarioEnergy ontarioWeather = ConvertStringToObject.covertFromJsonToOntario(message);
        String ontarioWeatherString = ConvertObjectToString.convertFromOntarioWeatherToString(ontarioWeather);
        System.out.println("Sending convert object: " + ontarioWeatherString);
        sender.send("filtered-data", ontarioWeatherString);
    }
}
