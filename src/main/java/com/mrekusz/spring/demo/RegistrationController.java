package com.mrekusz.spring.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/register")
public class RegistrationController {


    @GetMapping
    public String prepareRegistrationPage() {
        return "/WEB-INF/views/views.jsp";
    }

    @PostMapping
    public String processRegistrationPage() {

        return "";
    }

}