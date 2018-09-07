package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {

    @Test
    void shouldAddMoveToBoard(){
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}});
        UserMove move = new UserMove(1,1);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Success(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnErrorIfMoveOutOfBounds(){
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}});
        Player player = new Player("Cameo", "X");
        UserMove outOfBoundsMove = new UserMove(1,5);

        Result expectedResult = new Result.Error(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(outOfBoundsMove, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnErrorIfSpaceAlreadyTaken(){
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{" ", " ", " "}, {" ", "X", " "}, {" ", " ", " "}});
        UserMove move = new UserMove(1,1);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Error(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnDrawIfBoardFull() {
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{"X", "0", "X"}, {"0", "X", "0"}, {"0", "X", " "}});
        UserMove move = new UserMove(1,1);
        Player player0 = new Player("Cameo", "0");

        Result expectedResult = new Result.Draw(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(new UserMove(2,2), player0);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldMatchTokenForWinningCombination(){
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{"X", "X", "X"}, {" ", " ", " "}, {" ", " ", " "}});
        Player player = new Player("Cameo", "X");

        WinningCombination horizontalRow = new WinningCombination(new UserMove(0,0), new UserMove(0,1), new UserMove(0,2));

        assertTrue(gameBoard.tokenMatchAtPosition(horizontalRow, player));
    }

    @Test
    void shouldReturnWinForTopHorizontalRow() {
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{"X", "X", " "}, {" ", " ", " "}, {" ", " ", " "}});
        UserMove move = new UserMove(0,2);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Win(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnWinForMiddleHorizontalRow() {
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{" ", " ", " "}, {"X", "X", " "}, {" ", " ", " "}});
        UserMove move = new UserMove(1,2);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Win(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnWinForBottomHorizontalRow() {
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{" ", " ", " "}, {" ", " ", " "}, {"X", "X", " "}});
        UserMove move = new UserMove(2,2);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Win(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnWinForLeftColumn() {
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{"X", " ", " "}, {"X", " ", " "}, {" ", " ", " "}});
        UserMove move = new UserMove(2,0);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Win(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnWinForMiddleColumn() {
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{" ", "X", " "}, {" ", "X", " "}, {" ", " ", " "}});
        UserMove move = new UserMove(2,1);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Win(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnWinForRightColumn() {
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{" ", " ", "X"}, {" ", " ", "X"}, {" ", " ", " "}});
        UserMove move = new UserMove(2,2);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Win(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnWinForLeftDiagonal() {
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{"X", " ", " "}, {" ", "X", " "}, {" ", " ", " "}});
        UserMove move = new UserMove(2,2);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Win(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnWinForRightDiagonal() {
        GameBoard gameBoard = new TicTacToeBoard(new String[][] {{" ", " ", "X"}, {" ", "X", " "}, {" ", " ", " "}});
        UserMove move = new UserMove(2,0);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Win(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }
}