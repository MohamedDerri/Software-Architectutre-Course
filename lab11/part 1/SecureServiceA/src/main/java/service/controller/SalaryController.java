package service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salaries")
public class SalaryController {
    @Autowired
    OAuth2RestTemplate restTemplate;

    @GetMapping
    public String getSalary() {
        return restTemplate.getForObject("http://localhost:8102/salary", String.class);
    }
}
