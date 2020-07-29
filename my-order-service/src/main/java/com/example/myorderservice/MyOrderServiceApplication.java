package com.example.myorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyOrderServiceApplication.class, args);
    }

}
