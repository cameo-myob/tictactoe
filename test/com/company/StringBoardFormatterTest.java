package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBoardFormatterTest {

    @Test
    void shouldReturnFormattedString(){
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createWinBoard();
        Result boardResult = new Result.Win(tttBoard);

        StringBoardFormatter formatter = new StringBoardFormatter();
        String actualResult = formatter.format(boardResult);

        String[][] board = tttBoard.getBoard();
        String expectedResult = "|---|---|---|\n";
        expectedResult += "| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |\n";
        expectedResult += "|---|---|---|\n";
        expectedResult += "| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |\n";
        expectedResult += "|---|---|---|\n";
        expectedResult += "| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |\n";
        expectedResult += "|---|---|---|";

        assertEquals(expectedResult, actualResult);

    }

}