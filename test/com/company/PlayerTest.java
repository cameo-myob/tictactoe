package com.company;

import com.company.tictactoe.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void shouldReturnName(){
        Player player = new Player("Cameo", "X");
        String expectedResult = "Cameo";
        String actualResult = player.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnToken(){
        Player player = new Player("Cameo", "X");
        String expectedResult = "X";
        String actualResult = player.getToken();

        assertEquals(expectedResult, actualResult);
    }

}