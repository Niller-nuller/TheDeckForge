package org.example.thedeckforge.controller;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;
    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
    @GetMapping("/card-search")
    public String cardController(Model model) {
        model.addAttribute("searchTerm", "");
        return "card-search";
    }
    @GetMapping("/card-list")
    public String cardListController(@RequestParam String searchTerm, Model model){
        List<Card> searchResults = cardService.getCardListBasedOnSearchTerm(searchTerm);
        model.addAttribute("searchResults", searchResults);
        model.addAttribute("searchTerm", searchTerm);
        return "card-list";
    }
    @GetMapping("/card-detail/{id}")
    public String cardDetail(@PathVariable long id, Model model){
        Card card = cardService.getCardById(id);
        model.addAttribute("card", card);
        return "card-detail";
    }
}
