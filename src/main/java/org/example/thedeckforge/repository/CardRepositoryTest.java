package org.example.thedeckforge.repository;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.enums.CardType;
import org.example.thedeckforge.entity.repositoryinterface.ICardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CardRepositoryTest implements ICardRepository {


    private final List<Card> cardList = new ArrayList<>();

    @Override
    public void populateCardList(){
        cardList.add(new Card(1,"PoopMonkey", List.of(CardType.CREATURE),"Blue","NinjaTurtles","Very","This monkey throws Poop and so do you", "There is none","5",6,10));
        cardList.add(new Card(2,"PissMonkey", List.of(CardType.CREATURE),"Red","NinjaTurtles","Really not","This monkey Pisses on You", "There is none","2",2,2));
    }

    @Override
    public List<Card> returnCardList() {
        return cardList;
    }

    @Override
    public Optional<Card> returnCardById(int id) {
        return cardList.stream().filter(card -> card.getId() == id).findFirst();
    }
}
