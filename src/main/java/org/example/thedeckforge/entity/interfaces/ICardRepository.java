package org.example.thedeckforge.entity.interfaces;

import org.example.thedeckforge.entity.Card;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICardRepository {

    void populateCardList();
    List<Card> returnCardList();
    List<Card> returnCardListByName(String name);
    Optional<Card> returnCardById(int id);
    Optional<Card> returnCardByName(String name);
    Optional<Card> returnCardByType(String type);
    Optional<Card> returnIllegalStateOfCard();

}
