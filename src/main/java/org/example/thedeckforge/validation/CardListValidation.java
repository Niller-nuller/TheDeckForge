package org.example.thedeckforge.validation;

public class CardListValidation implements ValidationStrategy {
    @Override
    public ValidationType getValidationType() {
        return ValidationType.CARD_List;
    }

    @Override
    public void validate(Object object) {

    }
}
