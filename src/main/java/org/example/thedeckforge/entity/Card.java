package org.example.thedeckforge.entity;

import org.example.thedeckforge.entity.enums.CardType;
import org.example.thedeckforge.validation.exceptions.CardValidationException;

public class Card {
    private long id;
    private String cardName;
    private CardType cardType;
    private String color;
    private String set;
    private String rarity;
    private String ruleText;
    private String pictureRef;
    private String manaCost;
    private Integer attack;
    private Integer defense;

    public Card(){}

    public Card(long id, String cardName, CardType cardType, String color, String set, String rarity, String ruleText, String pictureRef, String manaCost, int attack, int defense) {
        if(id <= 0){
            throw new CardValidationException("Card id must be greater than 0");
        }
        if(cardName == null || cardName.isEmpty()){
            throw new CardValidationException("Card name cannot be empty");
        }
        if(cardType == null){
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
        this.id = id;
        this.cardName = cardName;
        this.cardType = cardType;
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
        if(cardName == null || cardName.isEmpty()){
            throw new CardValidationException("Card name cannot be empty");
        }
        this.cardName = cardName;
    }
    public CardType getCardType() {
        return cardType;
    }
    public void setCardType(CardType cardTypes) {
        if(cardTypes == null){
            throw new CardValidationException("Card types cannot be empty");
        }
        this.cardType = cardTypes;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        if(color == null || color.isEmpty()){
            throw new CardValidationException("Card color cannot be empty");
        }
        this.color = color;
    }
    public String getSet() {
        return set;
    }
    public void setSet(String set) {
        if(set == null || set.isEmpty()){
            throw new CardValidationException("Card set cannot be empty");
        }
        this.set = set;
    }
    public String getRarity() {
        return rarity;
    }
    public void setRarity(String rarity) {
        if(rarity == null || rarity.isEmpty()){
            throw new CardValidationException("Card rarity cannot be empty");
        }
        this.rarity = rarity;
    }
    public String getRuleText() {
        return ruleText;
    }
    public void setRuleText(String ruleText) {
        if(ruleText == null || ruleText.isEmpty()){
            throw new CardValidationException("Card rule text cannot be empty");
        }
        this.ruleText = ruleText;
    }
    public String getPictureRef() {
        return pictureRef;
    }
    public void setPictureRef(String pictureRef) {
        if(pictureRef == null || pictureRef.isEmpty()){
            throw new CardValidationException("Card picture ref cannot be empty");
        }
        this.pictureRef = pictureRef;
    }
    public String getManaCost() {
        return manaCost;
    }
    public void setManaCost(String manaCost) {
        if(manaCost == null || manaCost.isEmpty()){
            throw new CardValidationException("Card mana cost cannot be empty");
        }
        this.manaCost = manaCost;
    }
    public Integer getAttack(){
        return attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public Integer getDefense(){
        return defense;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
}
