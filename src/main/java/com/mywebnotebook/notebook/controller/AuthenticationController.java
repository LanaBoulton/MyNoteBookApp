package com.mywebnotebook.notebook.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    //handler method to handle login page request
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
