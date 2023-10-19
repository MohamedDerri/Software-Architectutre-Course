package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


	@GetMapping("/contact")
	public String getContact() {
		int range = (9999999 - 6412339) + 1;
		return "+ 641-" + String.valueOf(Math.abs((Math.random() * range) + 1));

	}

}

