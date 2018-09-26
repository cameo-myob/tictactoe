package com.company;

import com.company.tictactoe.parser.MoveParser;
import com.company.tictactoe.UserMove;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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