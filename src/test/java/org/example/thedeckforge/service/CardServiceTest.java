package org.example.thedeckforge.service;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.interfaces.ICardRepository;
import org.example.thedeckforge.repository.CardRepositoryTest;
import org.example.thedeckforge.validation.exceptions.CardValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class CardServiceTest {

    private ICardRepository cardRepository;
    private ValidationService validationService;

    @BeforeEach
    public void setUp(){

        cardRepository = new CardRepositoryTest();
        cardRepository.populateCardList();
    }

    @Test
    public void returnCardListTest() {
        List<Card> cardResult = cardRepository.returnCardList();

        Assertions.assertNotNull(cardResult);
        Assertions.assertFalse(cardResult.isEmpty());
        Assertions.assertEquals(2, cardResult.size());
    }
    @Test
    public void returnEmptyCardListTestBasedOnCriteria(){
        List<Card> cardResult = cardRepository.returnCardListByName("Boppy");
        Assertions.assertTrue(cardResult.isEmpty());
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
        CardValidationException exception = Assertions.assertThrows(CardValidationException.class, () -> {} );
        Optional<Card> cardResult = cardRepository.returnCardByName("P");
        Assertions.assertTrue(cardResult.isPresent());
    }
    @Test
    public void returnCardByNameFailTest() {
        Optional<Card> cardResult = cardRepository.returnCardByName("m");
        Assertions.assertFalse(cardResult.isPresent());
    }
    @Test
    public void returnIllegalStateOfCardTest(){
        CardValidationException exception = Assertions.assertThrows(CardValidationException.class, () -> {
            cardRepository.returnIllegalStateOfCard();} );
    }
}