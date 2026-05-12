package org.example.thedeckforge.service;
import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.interfaces.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class CardService {
    private final ICardRepository cardRepository;
    private final ValidationService validationService;

    @Autowired
    public CardService(ICardRepository cardRepository, ValidationService validationService) {
        this.cardRepository = cardRepository;
        this.validationService = validationService;
    }

    public List<Card> getCardListBasedOnSearchTerm(String searchTerm){
        return cardRepository.returnCardListByName(changeToLikeOperator(searchTerm));
    }

    private String changeToLikeOperator(String searchTerm){
        return "%" + searchTerm + "%";
    }

    public Card getCardById(long id){
        return cardRepository.returnCardById(id).orElseThrow(() -> new RuntimeException("Card with id " + id + " does not exist"));
    }
    public Card createDefaultCard(){
        return new Card();
    }

    public void saveCard(Card card, MultipartFile picture) throws IOException {
        String cardPictureRef = saveImage( picture);

        card.setPictureRef(cardPictureRef);

        cardRepository.saveCard(card);
    }

    private String saveImage(MultipartFile picture) throws IOException {
        if (!picture.isEmpty()) {
            Path uploadPath = Paths.get("target/classes/static/img/cards");
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String fileName = picture.getOriginalFilename();
            Files.copy(picture.getInputStream(), uploadPath.resolve(fileName),StandardCopyOption.REPLACE_EXISTING);
            return ("/img/cards/" + fileName);
        }
        return null;
    }
}
