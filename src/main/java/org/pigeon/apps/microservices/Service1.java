package org.pigeon.apps.microservices;
// Service1.java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Collections;

@SpringBootApplication
public class    Service1 {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Service1.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        app.run(args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

@RestController
class Service1Controller {

    private final RestTemplate restTemplate;


    public Service1Controller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/doubleAndDivide/{theNumber}")
    public Result doubleAndDivide(@PathVariable int theNumber) {
        // Service 1: Çarpma işlemi


        int doubledResult = theNumber * 2;

        // Service 2'ye HTTP isteği gönderme
        Result result = restTemplate.postForObject("http://localhost:8080/divideByThree", new Input(doubledResult), Result.class);

        return new Result(result.getResult());


    }
}