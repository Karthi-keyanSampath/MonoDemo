package com.demo.AgenticAI.controller;

import java.util.Date;
import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControlller {

    @GetMapping("/")
    public String home(HttpServletRequest request) {

        // ❌ Deprecated Java constructor
        Integer port = Integer.valueOf(8080);

        // ❌ Deprecated java.util.Date API
        Date date = new Date();
        int year = date.getYear(); // deprecated

        // ❌ Deprecated Spring utility method
        if (ObjectUtils.isEmpty(request.getRemoteAddr())) {
            return "Unknown client";
        }

        // ❌ Optional misuse (discouraged, common legacy pattern)
        Optional<String> client =
                Optional.ofNullable(request.getRemoteAddr());

        return "Hello World from "
                + client.orElse("N/A")
                + " | year=" + year
                + " | port=" + port;
    }

    @GetMapping("/health")
    public String health(HttpServletRequest request) {

        // ❌ Deprecated boxed primitive constructor
        Boolean healthy = Boolean.valueOf(true);

        return healthy.toString();
    }
}
