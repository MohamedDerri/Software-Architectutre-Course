package miu.edu.OntarioJSONDataRipperService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OntarioJsonDataRipperServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OntarioJsonDataRipperServiceApplication.class, args);
	}

}
