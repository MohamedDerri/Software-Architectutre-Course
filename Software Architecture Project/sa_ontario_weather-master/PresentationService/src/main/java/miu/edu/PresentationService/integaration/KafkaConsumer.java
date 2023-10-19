package miu.edu.PresentationService.integaration;

import miu.edu.PresentationService.dao.OntarioEnergyRepository;
import miu.edu.PresentationService.domain.OntarioEnergy;
import miu.edu.PresentationService.service.ConvertStringToObject;
import miu.edu.PresentationService.service.OntarioEnergyAdapter;
import miu.edu.PresentationService.service.OntarioEnergyDTO;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private OntarioEnergyRepository repository;

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

    @KafkaListener(topics = "filtered-data")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message from ripper service: " + message);
        OntarioEnergyDTO ontarioWeatherDTO = ConvertStringToObject.covertFromJsonToOntario(message);
        OntarioEnergy ontarioWeather = OntarioEnergyAdapter.convertFromDtoToOntarioWeather(ontarioWeatherDTO);
        ontarioWeather.setDate(new Date());
        repository.save(ontarioWeather);
    }
}
