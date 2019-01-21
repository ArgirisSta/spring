package com.dataverse.project.controllers;

import com.dataverse.project.exceptions.EmailAlreadyExistsException;
import com.dataverse.project.forms.RegistrationForm;
import com.dataverse.project.forms.UpdateForm;
import com.dataverse.project.models.LoggedUser;
import com.dataverse.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "register";
    }

    @PostMapping(value = "/register")
    public String handleRegistrationForm(Model model, @Valid @ModelAttribute("registrationForm")
            RegistrationForm registrationForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            userService.existsUserByEmail(registrationForm.getEmail());
            userService.registerUser(registrationForm);
        } catch (EmailAlreadyExistsException e) {
            model.addAttribute("emailDuplicate", registrationForm.getEmail());
            return "register";
        }

        return "login";
    }

    @GetMapping(value = "/user")
    public String showUserPanel(Model model) {
        model.addAttribute("updateForm", new UpdateForm());
        LoggedUser user = (LoggedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("loggedUser", user);
        return "panel";
    }

    @PostMapping(value = "/user/update")
    public String handleUserPanel(Model model, @Valid @ModelAttribute("updateForm")
            UpdateForm updateForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "panel";
        }

        userService.updateUser(updateForm);

        model.addAttribute("updateSuccess", "User information updated!");
        model.addAttribute("loggedUser", updateForm);

        return "login";
    }
}



