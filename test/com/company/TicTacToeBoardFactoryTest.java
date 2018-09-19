package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardFactoryTest {
    // win, draw, empty, test, no input

    @Test
    void shouldReturnWinBoard() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createBoard("win");
        String[][] expectedResult = new String[][] {{"X", "X", "X"}, {" ", " ", " "}, {" ", " ", " "}};
        String[][] actualResult = tttBoard.getBoard();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnDrawBoard() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createBoard("draw");
        String[][] expectedResult = new String[][] {{"X", "0", "X"}, {"0", "X", "0"}, {"0", "X", "0"}};
        String[][] actualResult = tttBoard.getBoard();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnEmptyBoard() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createBoard("empty");
        String[][] expectedResult = new String[][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        String[][] actualResult = tttBoard.getBoard();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnTestBoard() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createBoard("test");
        String[][] expectedResult = new String[][] {{"X", "X", " "}, {"0", "0", "X"}, {"X", "X", "0"}};
        String[][] actualResult = tttBoard.getBoard();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnEmptyBoardOnNoInput() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createBoard("");
        String[][] expectedResult = new String[][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        String[][] actualResult = tttBoard.getBoard();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnEmptyBoardOnInvalidInput() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createBoard("hello");
        String[][] expectedResult = new String[][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        String[][] actualResult = tttBoard.getBoard();

        assertArrayEquals(expectedResult, actualResult);
    }
}