package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {

    @Test
    void shouldAddMoveToBoard(){
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createBoard("empty");
        UserMove move = new UserMove(1,1);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Success(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnErrorIfMoveOutOfBounds(){
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createBoard("empty");
        Player player = new Player("Cameo", "X");
        UserMove outOfBoundsMove = new UserMove(1,5);

        Result expectedResult = new Result.Error(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(outOfBoundsMove, player);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnErrorIfSpaceAlreadyTaken(){
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createBoard("test");
        UserMove move = new UserMove(2,2);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Error(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnDrawIfBoardFull() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createBoard("test");
        UserMove move = new UserMove(1,3);
        Player player0 = new Player("Cameo", "0");

        Result expectedResult = new Result.Draw(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(move, player0);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldMatchTokenForWinningCombination(){
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createBoard("win");
        Player player = new Player("Cameo", "X");

        WinningCombination horizontalRow = new WinningCombination(new UserMove(1,1), new UserMove(1,2), new UserMove(1,3));

        assertTrue(tttBoard.tokenMatchAtPosition(horizontalRow, player));
    }

    @Test
    void shouldReturnWinForTopHorizontalRow() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createBoard("test");
        UserMove move = new UserMove(1,3);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Win(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult, actualResult);
    }
}