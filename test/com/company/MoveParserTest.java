package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveParserTest {

    @Test
    void shouldReturnUserMove(){
        UserMove expectedResult = new UserMove(1,2);
        UserMove actualResult = MoveParser.parse("1,2");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnCorrectUserMoveWithExcessInput(){
        UserMove expectedResult = new UserMove(1,2);
        UserMove actualResult = MoveParser.parse("1,2,3,4,5,84395");

        assertEquals(expectedResult, actualResult);
    }

}