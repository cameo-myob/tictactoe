package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {
    @Test
    void shouldCreateBoard(){
        GameBoard actualGameBoard = new GameBoard();
        String[][] expectedGameBoard = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
        assertArrayEquals(expectedGameBoard, actualGameBoard.returnBoard());
    }

    @Test
    void shouldCheckForEmptySpace(){
        GameBoard actualGameBoard = new GameBoard();
        assertTrue(actualGameBoard.isValidMove("1,1"));

    }

    @Test
    void shouldAddMoveToBoard(){
        GameBoard actualGameBoard = new GameBoard();
        String userMove = "1,1";
        String userToken = "X";

        String[][] expectedGameBoard = {{userToken, "", ""}, {"", "", ""}, {"", "", ""}};
        assertArrayEquals(expectedGameBoard, actualGameBoard.addMove(userMove, userToken));
    }

    @Test
    void shouldCheckForWin(){
        GameBoard actualGameBoard = new GameBoard();
        assertFalse(actualGameBoard.isWon());
    }

    @Test
    void shouldCheckForDraw(){
        GameBoard actualGameBoard = new GameBoard();
        assertFalse(actualGameBoard.isDraw());
    }


    // checks if move will fit in board
    // adds move to board
    // check if move won game
    // check if move drew game
}