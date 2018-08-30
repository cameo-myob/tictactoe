package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {

    @Test
    void shouldCheckForEmptySpace(){
        GameBoard actualGameBoard = new TicTacToeBoard();
        UserMove move = new UserMove(1,1);
        assertTrue(actualGameBoard.isEmptySpace(move));

    }

    @Test
    void shouldAddMoveToBoard(){
        GameBoard gameBoard = new TicTacToeBoard();
        UserMove move = new UserMove(1,1);
        String userToken = "X";
        assertTrue(gameBoard.addMoveToBoard(move, userToken));
    }

//    @Test
//    void shouldCheckForWin(){
//        GameBoard actualGameBoard = new TicTacToeBoard();
//        assertFalse(actualGameBoard.isWon());
//    }
//
//    @Test
//    void shouldCheckForDraw(){
//        GameBoard actualGameBoard = new TicTacToeBoard();
//        assertFalse(actualGameBoard.isDraw());
//    }
}