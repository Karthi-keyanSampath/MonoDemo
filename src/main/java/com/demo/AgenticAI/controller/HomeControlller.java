package com.demo.AgenticAI.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControlller {

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "Hello World from " + request.getRemoteAddr();
    }

    @GetMapping("/health")
    public String health(HttpServletRequest request) {
        return "health";
    }
}
