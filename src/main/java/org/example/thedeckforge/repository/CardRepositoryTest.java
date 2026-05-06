package org.example.thedeckforge.repository;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.enums.CardType;
import org.example.thedeckforge.entity.interfaces.ICardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CardRepositoryTest implements ICardRepository {


    private final List<Card> cardList = new ArrayList<>();

    @Override
    public void populateCardList(){
        cardList.add(new Card(1,"PoopMokey", List.of(CardType.CREATURE),"Blue","NinjaTurtles","Very","This monkey throws Poop and so do you", "There is none","5",6,10));
        cardList.add(new Card(1,"PissMonkey", List.of(CardType.CREATURE),"Red","NinjaTurtles","Really not","This monkey Pisses on You", "There is none","2",2,2));
    }

    @Override
    public List<Card> returnCardList() {
        return cardList;
    }
    @Override
    public List<Card> returnCardListByName(String name) {
        return cardList.stream().filter(Card -> Card.getCardName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public Optional<Card> returnCardById(int requestId) {
        return cardList.stream().filter(card -> card.getId() == requestId).findFirst();
    }

    @Override
    public Optional<Card> returnCardByName(String name) {
        return cardList.stream().filter(card -> card.getCardName().contains(name)).findFirst();
    }

    @Override
    public Optional<Card> returnCardByType(String type) {
        return Optional.empty();
    }
    @Override
    public Optional<Card> returnIllegalStateOfCard(){
        Card card = new Card(5,null,null,null,null,null,null,null,null,0,0);
        return Optional.of(card);
    }
}
