package org.example.thedeckforge.controller;

import jakarta.servlet.http.HttpSession;
import org.example.thedeckforge.entity.Authority;
import org.example.thedeckforge.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final LogInService logInService;
    @Autowired
    public LoginController(LogInService logInService) {
        this.logInService = logInService;
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("Authority", new Authority());
        return "login";
    }
}
