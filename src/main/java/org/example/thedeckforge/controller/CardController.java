package org.example.thedeckforge.controller;

import org.example.thedeckforge.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/cards")
public class CardController {

    private CardService cardService;

    @GetMapping("/card-search")
    public String cardController(Model model){
        model.addAttribute("search","");
        return "card-search";
    }
    @GetMapping("/card-list")
    public String cardListController(Model model){
//        model.addAttribute("card",cardService.);
        return "card-list";
    }
    @GetMapping("/card-detail")
    public String cardDetail(Model model){
        return "card-detail";
    }
}
