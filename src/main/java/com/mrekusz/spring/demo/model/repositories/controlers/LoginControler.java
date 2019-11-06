package com.mrekusz.spring.demo.model.repositories.controlers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginControler {


    @GetMapping
    public String prepareLoginPage() {

        return "/WEB-INF/views/login-page.jsp";


    }
}
