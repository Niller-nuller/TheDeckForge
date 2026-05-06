package org.example.thedeckforge.service;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.repositoryinterface.ICardRepository;
import org.example.thedeckforge.repository.CardRepositoryTest;
import org.example.thedeckforge.validation.CardValidation;
import org.example.thedeckforge.validation.ValidationStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.*;

class CardServiceTest {

    private ICardRepository cardRepository;
    private ValidationStrategy validationStrategy;
    @BeforeEach
    public void setUp(){
        cardRepository = new CardRepositoryTest();
        cardRepository.populateCardList();
        validationStrategy = new CardValidation();
    }

    @Test
    public void returnCardListTest() {
        List<Card> cardResult = cardRepository.returnCardList();

        Assertions.assertNotNull(cardResult);
        Assertions.assertFalse(cardResult.isEmpty());
        Assertions.assertEquals(2, cardResult.size());
    }
    @Test
    public void returnCardByIdTest() {
        Optional<Card> cardResult = cardRepository.returnCardById(1);
        Assertions.assertTrue(cardResult.isPresent());
    }
    @Test
    public void returnCardByIdFailTest() {
        Optional<Card> cardResult = cardRepository.returnCardById(10);
        Assertions.assertFalse(cardResult.isPresent());
    }
    @Test
    public void returnCardByNameTest() {
        Optional<Card> cardResult = cardRepository.returnCardByName("P");
        Assertions.assertTrue(cardResult.isPresent());
        Assertions.assertThrows(C)
    }
    @Test
    public void returnCardByNameFailTest() {
        Optional<Card> cardResult = cardRepository.returnCardByName("m");
        Assertions.assertFalse(cardResult.isPresent());
    }
}