package org.example.thedeckforge.validation;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.validation.exceptions.CardValidationException;

public class CardValidation implements ValidationStrategy {


    @Override
    public ValidationType getValidationType() {
        return ValidationType.CARD;
    }

    @Override
    public void validate(Object object) {
        if(!(object instanceof Card card)) {
            throw new CardValidationException("Card object must be an instance of Card");
        }
        if(card.getCardName() == null || card.getCardName().isEmpty()) {
            throw new CardValidationException("Card name cannot be empty");
        }
    }
}
