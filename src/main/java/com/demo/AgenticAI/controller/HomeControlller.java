package com.demo.AgenticAI.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils; // deprecated in Spring 5.3+
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControlller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {

        // ❌ Deprecated Java constructor
        Integer port = new Integer(8080);

        // ❌ Deprecated java.util.Date API
        Date date = new Date();
        int year = date.getYear(); // deprecated

        // ❌ Deprecated Spring utility method
        if (StringUtils.isEmpty(request.getRemoteAddr())) {
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

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health(HttpServletRequest request) {

        // ❌ Deprecated boxed primitive constructor
        Boolean healthy = new Boolean(true);

        return healthy.toString();
    }
}
