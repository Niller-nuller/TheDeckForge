package org.example.thedeckforge.controller;

import org.example.thedeckforge.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private final LogInService logInService;
    @Autowired
    public LoginController(LogInService logInService) {
        this.logInService = logInService;
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("Authority", logInService.getLoginRequest());
        return "login";
    }
}
