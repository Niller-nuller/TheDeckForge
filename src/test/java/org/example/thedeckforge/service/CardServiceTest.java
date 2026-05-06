package org.example.thedeckforge.service;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.repositoryinterface.ICardRepository;
import org.example.thedeckforge.repository.CardRepositoryTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

class CardServiceTest {

    private ICardRepository cardRepository;

    @BeforeEach
    public void setUp(){
        cardRepository = new CardRepositoryTest();
        cardRepository.populateCardList();
    }

    @Test
    public void returnCardListTest() {
        List<Card> result = cardRepository.returnCardList().stream().toList();

        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void returnCardTest() {
        Optional<Card> result = cardRepository.returnCardById(3);
        Assertions.assertTrue(result.isEmpty());
    }
    @Test
    public void returnCardByNameTest(){

    }


}