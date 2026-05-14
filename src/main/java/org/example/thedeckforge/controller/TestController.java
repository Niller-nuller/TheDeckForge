package org.example.thedeckforge.controller;

import org.example.thedeckforge.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/test-auth")
    @ResponseBody  // returns plain text instead of looking for a template
    public String testAuth(@AuthenticationPrincipal User user) {
        if (user == null) {
            return "No user found — not logged in";
        }
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getAuthority().getUsername());
        System.out.println(user.getAuthority().getUsername());
        return "Logged in as: " + user.getName() + " | Role: " + user.getAuthority().getAuthorities();
    }
}
