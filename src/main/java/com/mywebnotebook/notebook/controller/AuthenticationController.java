package com.mywebnotebook.notebook.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    //login page request
    //http://localhost:8080/login
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
