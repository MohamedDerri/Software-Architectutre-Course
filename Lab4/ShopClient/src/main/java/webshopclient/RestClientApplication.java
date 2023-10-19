package webshopclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {


	RestTemplate restTemplate = new RestTemplate();
	private String serverUrl = "http://localhost:8080";

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restTemplate.postForLocation(serverUrl + "/products", new Product("0002","shoes", 59.99, "nike shoes"));
		System.out.println("new product added successfully");

		System.out.println("Getting Product");
		Product product = restTemplate.getForObject(serverUrl + "/products/0002",Product.class);
		System.out.println(product);

		System.out.println("Adding Product to Shopping Cart");
		restTemplate.postForLocation(serverUrl + "/carts", new AddToCartDto(2,"0002", 5));

		System.out.println("product added to shopping cart");
	}
}
