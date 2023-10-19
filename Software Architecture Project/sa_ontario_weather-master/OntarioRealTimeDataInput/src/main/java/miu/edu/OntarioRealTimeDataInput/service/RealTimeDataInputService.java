package miu.edu.OntarioRealTimeDataInput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class RealTimeDataInputService {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Scheduled(fixedDelay = 10000)
//    @Scheduled(cron = "@hourly")
    public void getData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://live.gridwatch.ca/WebServices/GridWatchWebApp.asmx/GetHomeViewData_v2";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String answer = restTemplate.getForObject(url, String.class, entity);
        System.out.println(answer);
        //published data to stream using KafkaProducer
        kafkaProducer.sendMessage(answer);
    }
}
