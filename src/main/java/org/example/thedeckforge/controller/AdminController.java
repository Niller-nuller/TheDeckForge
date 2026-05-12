package org.example.thedeckforge.controller;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.User;
import org.example.thedeckforge.entity.enums.CardType;
import org.example.thedeckforge.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CardService cardService;

    @Autowired
    public AdminController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/create-card-form")
    public String createCardForm(Model model) {
        model.addAttribute("Card",cardService.createDefaultCard());
        model.addAttribute("cardTypes", CardType.values());
        return "create-card-form";
    }
    @PostMapping("/create-card")
    public String createCard(@ModelAttribute("Card") Card card, @RequestParam("pictureRef")MultipartFile picture, @SessionAttribute User adminUser) throws IOException {
        if (!picture.isEmpty()) {
            Path uploadPath = Paths.get("src/main/resources/static/images");
            if(!Files.exists(uploadPath)){
                Files.createDirectories(Path.of("src/main/resources/static/images"));
            }
            String fileName = UUID.randomUUID() + ".jpg" + picture.getOriginalFilename();
            Files.copy(picture.getInputStream(), uploadPath.resolve(fileName));
            card.setPictureRef(fileName);
        }
        cardService.saveCard(card,adminUser);
        return "create-card-form";
    }
}
