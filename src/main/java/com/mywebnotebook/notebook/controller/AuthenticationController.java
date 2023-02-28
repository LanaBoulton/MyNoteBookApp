package com.mywebnotebook.notebook.controller;

import com.mywebnotebook.notebook.dto.RegistrationDto;
import com.mywebnotebook.notebook.entity.Guest;
import com.mywebnotebook.notebook.service.GuestService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    private GuestService guestService;

    public AuthenticationController(GuestService guestService) {
        this.guestService = guestService;
    }

    //handler method to handle user registration request
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        // guest object stores data from the form
        RegistrationDto guest = new RegistrationDto();
        model.addAttribute("guest", guest);
        return "register";
    }

    //handler method to handle guest registration form submit request
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("guest") RegistrationDto guest,
                           BindingResult result,
                           Model model){
        Guest existingGuest =guestService.findByEmail(guest.getEmail());
        if (existingGuest!=null && existingGuest.getEmail()!=null && !existingGuest.getEmail().isEmpty()){
            result.rejectValue("email", null, "I already have a guest with this email");
        }
        if(result.hasErrors()){
            model.addAttribute("guest", guest);
            return "register";
        }
        guestService.saveGuest(guest);
        return "redirect:/register?success";
    }
}
