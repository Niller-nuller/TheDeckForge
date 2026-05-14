package org.example.thedeckforge.controller;


import org.example.thedeckforge.entity.User;
import org.example.thedeckforge.service.DeckService;
import org.example.thedeckforge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/decks")
public class DeckController {
    private final DeckService deckService;
    private final UserService userService;

    @Autowired
    public DeckController(DeckService deckService, UserService userService) {
        this.deckService = deckService;
        this.userService = userService;
    }
    @GetMapping("/user-decks")
    public String userDecks(Model model, Authentication authentication) {
        User user = userService.getCurrentUser(authentication);
        user.setDecks(deckService.getUserDecks(user));
        model.addAttribute("user", user);
        return "user-decks";
    }
}

