package org.example.thedeckforge.entity.repositoryinterface;

import org.example.thedeckforge.entity.Card;

import java.util.List;

public interface ICardRepository {

    void populateCardList();
    List<Card> returnCardList();
}
