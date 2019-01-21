package com.dataverse.project.controllers;

import com.dataverse.project.forms.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String showLoginPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "login";
    }
}
