package org.example.thedeckforge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/cards")
public class CardController {

    @GetMapping("/cardlist")
    public String cardController(Model model){

        return "/cardlist";
    }
}
