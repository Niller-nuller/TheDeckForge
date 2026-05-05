package org.example.thedeckforge.service;

import org.example.thedeckforge.entity.repositoryinterface.ICardRepository;
import org.example.thedeckforge.repository.CardRepositoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class CardServiceTest {

    private ICardRepository cardRepository;

    @BeforeEach
    public void setUp(){
        cardRepository = new CardRepositoryTest();
        cardRepository.populateCardList();
    }

    @Test
    public void returnCardListTest() {
        cardRepository.returnCardList();

    }

}