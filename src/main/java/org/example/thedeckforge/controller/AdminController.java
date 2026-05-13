package org.example.thedeckforge.controller;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.User;
import org.example.thedeckforge.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CardService cardService;

    @Autowired
    public AdminController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/create-card-from")
    public String createCardForm(Model model) {
        model.addAttribute("card",cardService.createCard());
        return "create-card-form";
    }
    @GetMapping("/create-card")
    public String createCard(@ModelAttribute Card card, @SessionAttribute User adminUser) {
        cardService.saveCard(card, adminUser);
        return "create-card-form";
    }
}
