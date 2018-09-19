package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardFactoryTest {

    @Test
    void shouldReturnWinBoard() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createWinBoard();
        String[][] expectedResult = new String[][] {{"X", "X", "X"}, {" ", " ", " "}, {" ", " ", " "}};
        String[][] actualResult = tttBoard.getBoard();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnDrawBoard() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createDrawBoard();
        String[][] expectedResult = new String[][] {{"X", "0", "X"}, {"0", "X", "0"}, {"0", "X", "0"}};
        String[][] actualResult = tttBoard.getBoard();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnEmptyBoard() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createEmptyBoard();
        String[][] expectedResult = new String[][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        String[][] actualResult = tttBoard.getBoard();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnTestBoard() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createTestBoard();
        String[][] expectedResult = new String[][] {{"X", "X", " "}, {"0", "0", "X"}, {"X", "X", "0"}};
        String[][] actualResult = tttBoard.getBoard();

        assertArrayEquals(expectedResult, actualResult);
    }
}