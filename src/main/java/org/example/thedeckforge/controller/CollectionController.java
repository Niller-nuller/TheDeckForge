package org.example.thedeckforge.controller;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.User;
import org.example.thedeckforge.service.CollectionService;
import org.example.thedeckforge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/collection")
public class CollectionController {

    private static final int PAGE_SIZE = 30;

    private final UserService userService;
    private final CollectionService collectionService;

    @Autowired
    public CollectionController(CollectionService collectionService, UserService userService) {
        this.collectionService = collectionService;
        this.userService = userService;
    }

    @GetMapping
    public String viewCollection(@AuthenticationPrincipal User user, @RequestParam(defaultValue = "0") int page, Model model) {
        if (user == null) {
            return "redirect:/login";
        }

        int totalCards = collectionService.countOwnedCards(user.getId());
        int totalPages = Math.max(1, (int) Math.ceil((double) totalCards / PAGE_SIZE));

        if (page < 0) page = 0;
        if (page >= totalPages) page = totalPages - 1;

        List<Card> cards = collectionService.getOwnedCards(user.getId(), page, PAGE_SIZE);
        user.getCollection().setCards(cards);

        int firstShown = totalCards == 0 ? 0 : page * PAGE_SIZE + 1;
        int lastShown  = Math.min((page + 1) * PAGE_SIZE, totalCards);

        model.addAttribute("user", user);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalCards", totalCards);
        model.addAttribute("firstShown", firstShown);
        model.addAttribute("lastShown", lastShown);

        return "collection/view";
    }
}
