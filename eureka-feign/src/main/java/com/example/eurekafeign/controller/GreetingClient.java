package com.example.eurekafeign.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="spring-cloud-eureka-client", url = "http://localhost:9000", decode404 = true)
public interface GreetingClient {
    @RequestMapping("/greeting")
    String greeting();
}
