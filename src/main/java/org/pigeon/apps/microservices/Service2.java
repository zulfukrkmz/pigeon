package org.pigeon.apps.microservices;

// Service2.java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class Service2 {

    public static void main(String[] args) {
        SpringApplication.run(Service2.class, args);
    }
}

@RestController
class Service2Controller {

    @PostMapping("/divideByThree")
    public Result divideByThree(@RequestBody Input input) {
        int result = input.getNumber() / 3;
        return new Result(result);
    }
}