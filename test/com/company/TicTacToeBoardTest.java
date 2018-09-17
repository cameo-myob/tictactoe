package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {

    @Test
    void shouldAddMoveToBoard(){
        GameBoardFactory tttBoard = new TicTacToeBoardFactory();
        GameBoard gameBoard = tttBoard.createBoard("empty");
        UserMove move = new UserMove(1,1);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Success(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult, actualResult);
    }


    @Test
    void shouldReturnErrorIfMoveOutOfBounds(){
        GameBoardFactory tttBoard = new TicTacToeBoardFactory();
        GameBoard gameBoard = tttBoard.createBoard("empty");
        Player player = new Player("Cameo", "X");
        UserMove outOfBoundsMove = new UserMove(1,5);

        Result expectedResult = new Result.Error(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(outOfBoundsMove, player);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnErrorIfSpaceAlreadyTaken(){
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{" ", " ", " "}, {" ", "X", " "}, {" ", " ", " "}});
        UserMove move = new UserMove(2,2);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Error(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnDrawIfBoardFull() {
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{"X", "0", "X"}, {"0", "X", "0"}, {"0", "X", " "}});
        UserMove move = new UserMove(3,3);
        Player player0 = new Player("Cameo", "0");

        Result expectedResult = new Result.Draw(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player0);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldMatchTokenForWinningCombination(){
        GameBoardFactory tttBoard = new TicTacToeBoardFactory();
        GameBoard gameBoard = tttBoard.createBoard("win");
        Player player = new Player("Cameo", "X");

        WinningCombination horizontalRow = new WinningCombination(new UserMove(1,1), new UserMove(1,2), new UserMove(1,3));

        assertTrue(gameBoard.tokenMatchAtPosition(horizontalRow, player));
    }

    @Test
    void shouldReturnWinForTopHorizontalRow() {
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{"X", "X", " "}, {" ", " ", " "}, {" ", " ", " "}});
        UserMove move = new UserMove(1,3);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Win(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult, actualResult);
    }
}