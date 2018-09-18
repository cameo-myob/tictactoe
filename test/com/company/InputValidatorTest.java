package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void shouldReturnTrueForValidInput(){
        boolean result = InputValidator.validate("1,1");

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForCharInput(){
        boolean result = InputValidator.validate("hello");

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseForEmptyInput(){
        boolean result = InputValidator.validate("");

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseForIntAndCharInput(){
        boolean result = InputValidator.validate("1hg,s54");

        assertFalse(result);
    }
}
