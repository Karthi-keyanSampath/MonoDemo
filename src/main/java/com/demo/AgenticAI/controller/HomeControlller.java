package com.demo.AgenticAI.controller;

import java.util.Date;
import java.util.Optional;
import java.util.Vector; // legacy synchronized collection

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired; // field injection (discouraged)
import org.springframework.stereotype.Controller; // legacy MVC style
import org.springframework.ui.Model;
import org.springframework.util.StringUtils; // deprecated in Spring 5.3+
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeControlller {

    // ❌ Field injection (discouraged, legacy Spring style)
    @Autowired
    private HttpServletRequest injectedRequest;

    // ❌ Legacy RequestMapping instead of @GetMapping
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String home(HttpServletRequest request, Model model) {

        // ❌ Deprecated boxed primitive constructor
        Integer port = new Integer(8080);

        // ❌ Deprecated Boolean constructor
        Boolean enabled = new Boolean(true);

        // ❌ Deprecated Date API
        Date date = new Date();
        int year = date.getYear(); // deprecated
        int month = date.getMonth(); // deprecated

        // ❌ Deprecated Spring utility
        if (StringUtils.isEmpty(request.getRemoteAddr())) {
            return "Unknown client";
        }

        // ❌ Legacy synchronized collection
        Vector<String> clients = new Vector<>();
        clients.add(request.getRemoteAddr());

        // ❌ Optional misuse (Optional as a variable)
        Optional<String> client =
                Optional.ofNullable(request.getRemoteAddr());

        // ❌ Using injected servlet request instead of method param
        String agent = injectedRequest.getHeader("User-Agent");

        return "Hello World from "
                + client.orElse("N/A")
                + " | year=" + year
                + " | month=" + month
                + " | port=" + port
                + " | enabled=" + enabled
                + " | agent=" + agent;
    }

    // ❌ Legacy RequestMapping for health endpoint
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    @ResponseBody
    public String health() {

        // ❌ Deprecated boxed constructor
        Boolean healthy = new Boolean(true);

        // ❌ Legacy toString usage
        return healthy.toString();
    }
}
