package org.example.thedeckforge.entity;

import org.example.thedeckforge.entity.enums.CardType;

import java.util.List;

public class Card {
    private long id;
    private String cardName;
    private List<CardType> cardTypes;
    private String color;
    private String set;
    private String rarity;
    private String ruleText;
    private String pictureRef;
    private String manaCost;
    private int attack;
    private int defense;

    public Card(long id, String cardName, List<CardType> cardTypes, String color, String set, String rarity, String ruleText, String pictureRef, String manaCost, int attack, int defense) {
        this.id = id;
        this.cardName = cardName;
        this.cardTypes = cardTypes;
        this.color = color;
        this.set = set;
        this.rarity = rarity;
        this.ruleText = ruleText;
        this.pictureRef = pictureRef;
        this.manaCost = manaCost;
        this.attack = attack;
        this.defense = defense;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCardName() {
        return cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    public List<CardType> getCardTypes() {
        return cardTypes;
    }
    public void setCardTypes(List<CardType> cardTypes) {
        this.cardTypes = cardTypes;
    }
}
