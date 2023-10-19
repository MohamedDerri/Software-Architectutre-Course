package service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    OAuth2RestTemplate restTemplate;

    @GetMapping
    public String getContact() {
        return restTemplate.getForObject("http://localhost:8101/contact", String.class);
    }
}
