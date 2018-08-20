package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {
    @Test
    void shouldCreateBoard(){
        GameBoard actualGameBoard = new TicTacToeBoard();
        String[][] expectedGameBoard = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
        assertArrayEquals(expectedGameBoard, actualGameBoard.returnBoard());
    }

    @Test
    void shouldCheckForEmptySpace(){
        GameBoard actualGameBoard = new TicTacToeBoard();
        assertTrue(actualGameBoard.isValidMove("1,1"));

    }

    @Test
    void shouldAddMoveToBoard(){
        GameBoard actualGameBoard = new TicTacToeBoard();
        String userMove = "1,1";
        String userToken = "X";

        String[][] expectedGameBoard = {{userToken, "", ""}, {"", "", ""}, {"", "", ""}};
        assertArrayEquals(expectedGameBoard, actualGameBoard.addMove(userMove, userToken));
    }

    @Test
    void shouldCheckForWin(){
        GameBoard actualGameBoard = new TicTacToeBoard();
        assertFalse(actualGameBoard.isWon());
    }

    @Test
    void shouldCheckForDraw(){
        GameBoard actualGameBoard = new TicTacToeBoard();
        assertFalse(actualGameBoard.isDraw());
    }
}