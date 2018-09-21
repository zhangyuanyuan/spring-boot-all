package com.kg.springboot.springbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulApiWebController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
