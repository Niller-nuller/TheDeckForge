// controller/CollectionController.java
package org.example.thedeckforge.controller;

import jakarta.servlet.http.HttpSession;
import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.Collection;
import org.example.thedeckforge.entity.User;
import org.example.thedeckforge.service.CollectionService;
import org.example.thedeckforge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/collection")
public class CollectionController {

    private final UserService userService;
    private final CollectionService collectionService;

    @Autowired
    public CollectionController(CollectionService collectionService, UserService userService) {
        this.collectionService = collectionService;
        this.userService = userService;
    }

    @GetMapping
    public String viewCollection(Authentication auth, Model model) {
        User user = userService.getCurrentUser(auth);
        if (user == null) {
            return "redirect:/login";
        }

        List<Card> cards = collectionService.getOwnedCards(user.getId());
        user.getCollection().setCards(cards);

        model.addAttribute("user", user);
        return "collection/view";
    }
}