package org.example.thedeckforge.service;

import org.example.thedeckforge.entity.Card;
import org.example.thedeckforge.entity.enums.CardType;
import org.example.thedeckforge.validation.CardValidation;
import org.example.thedeckforge.validation.ValidationStrategy;
import org.example.thedeckforge.validation.ValidationType;
import org.example.thedeckforge.validation.exceptions.CardValidationException;
import org.example.thedeckforge.validation.exceptions.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

class ValidationServiceTest {

    private ValidationService validationService;
    private CardValidation CardValidation;

    @BeforeEach
    public void setUp() {
        CardValidation = new CardValidation();

        Map<String, ValidationStrategy> validatorMap = new HashMap<>();
        validatorMap.put(ValidationType.CARD.name(), CardValidation);

        validationService = new ValidationService(validatorMap);
    }
    @Test
    public void validate_WhenCardIsValid_NoExceptionThrown() {
        Card card = new Card(1, "PoopMonkey", List.of(CardType.CREATURE), "Blue",
                "NinjaTurtles", "Very", "This monkey throws Poop",
                "There is none", "5", 6, 10);

        Assertions.assertDoesNotThrow(() -> validationService.validate(ValidationType.CARD, card));
    }
    @Test
    public void validate_WhenNoValidatorFound_ThrowsValidationException() {
        ValidationException exception = Assertions.assertThrows(
                ValidationException.class,
                () -> validationService.validate(ValidationType.EMAIL, new Object())
        );

        Assertions.assertEquals("No validate found for type" + ValidationType.EMAIL, exception.getMessage());
    }
    @Test
    public void validate_WhenCardNameIsBlank_ThrowsCardValidationException() {
        Card card = new Card(1, "", List.of(CardType.CREATURE), "Blue",
                "NinjaTurtles", "Very", "desc", "none", "5", 6, 10);

        CardValidationException exception = Assertions.assertThrows(
                CardValidationException.class,
                () -> validationService.validate(ValidationType.CARD, card)
        );
        Assertions.assertEquals("Card name cannot be empty", exception.getMessage());
    }

    @Test
    public void validate_WhenCardPowerIsNegative_ThrowsCardValidationException() {
        Card card = new Card(1, "PoopMonkey", List.of(CardType.CREATURE), "Blue",
                "NinjaTurtles", "Very", "desc", "none", "5", -1, 10);

        CardValidationException exception = Assertions.assertThrows(
                CardValidationException.class,
                () -> validationService.validate(ValidationType.CARD, card)
        );

        Assertions.assertEquals("Card power cannot be negative", exception.getMessage());
    }
}