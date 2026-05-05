package org.example.thedeckforge.validation;


public interface ValidationStrategy {

    ValidationType getValidationType();
    void validate(Object object);
}
