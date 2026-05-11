package org.example.thedeckforge.service;


import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.interfaces.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CardService {
    private ICardRepository cardRepository;
    private ValidationService validationService;

    @Autowired
    public CardService(ICardRepository cardRepository, ValidationService validationService) {
        this.cardRepository = cardRepository;
        this.validationService = validationService;
    }

    public List<Card> getCardListBasedOnSearchCriteria(String searchCriteria){
        return cardRepository.returnCardListByName(changeToLikeOperator(searchCriteria));
    }

    private String changeToLikeOperator(String searchCriteria){
        return "%" + searchCriteria + "%";
    }





}
