package org.example.thedeckforge.entity;

import org.example.thedeckforge.entity.enums.CardType;
import org.example.thedeckforge.validation.exceptions.CardValidationException;

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
        if(id <= 0){
            throw new CardValidationException("Card id must be greater than 0");
        }
        if(cardName == null || cardName.isEmpty()){
            throw new CardValidationException("Card name cannot be empty");
        }
        if(cardTypes == null || cardTypes.isEmpty()){
            throw new CardValidationException("Card types cannot be empty");
        }
        if(color == null || color.isEmpty()){
            throw new CardValidationException("Card color cannot be empty");
        }
        if(set == null || set.isEmpty()){
            throw new CardValidationException("Card set cannot be empty");
        }
        if(rarity == null || rarity.isEmpty()){
            throw new CardValidationException("Card rarity cannot be empty");
        }
        if(ruleText == null || ruleText.isEmpty()){
            throw new CardValidationException("Card rule text cannot be empty");
        }
        if(pictureRef == null || pictureRef.isEmpty()){
            throw new CardValidationException("Card picture ref cannot be empty");
        }
        if(manaCost == null || manaCost.isEmpty()){
            throw new CardValidationException("Card mana cost cannot be empty");
        }
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
