package miu.edu.OntarioRealTimeDataInput;

import miu.edu.OntarioRealTimeDataInput.service.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@EnableConfigurationProperties(ApplicationProperties.class)
public class OntarioRealTimeDataInputApplication {

	public static void main(String[] args) {
		SpringApplication.run(OntarioRealTimeDataInputApplication.class, args);
	}

}
