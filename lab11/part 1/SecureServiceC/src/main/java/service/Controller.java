package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


	@GetMapping("/salary")
	public String getGetSalary() {
		int range = (1000000 - 10000) + 1;
		return String.valueOf(Math.abs((Math.random() * range) + 1));
	}

}

