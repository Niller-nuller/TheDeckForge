package org.example.thedeckforge.entity;

import org.example.thedeckforge.entity.enums.Privacy;
import java.util.ArrayList;
import java.util.List;

public class Collection {

    private List<Card> cards = new ArrayList<>();
    private Privacy privacy;

    public Collection() {}

    public List<Card> getCards()             { return cards; }
    public void setCards(List<Card> cards)   { this.cards = cards; }
    public Privacy getPrivacy()              { return privacy; }
    public void setPrivacy(Privacy privacy)  { this.privacy = privacy; }

    public int getCardCount()                { return cards.size(); }
}