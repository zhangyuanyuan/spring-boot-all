package com.kg.springboot.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringbootWebApplication {

    public static void main(String[] args) {
        System.out.println(" springApplication run !");
        SpringApplication.run(SpringbootWebApplication.class, args);
    }
}
