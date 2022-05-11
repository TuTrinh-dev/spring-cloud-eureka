package com.example.eurekafeign;

import com.example.eurekafeign.controller.GreetingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableFeignClients
@Controller
public class EurekaFeignApplication {
    @Autowired
    private GreetingClient greetingClient;

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignApplication.class, args);
    }

    @RequestMapping("/get-greeting")
    public String greeting(Model model) {
        model.addAttribute("greeting", greetingClient.greeting());
                return "greeting-view";
    }

}
