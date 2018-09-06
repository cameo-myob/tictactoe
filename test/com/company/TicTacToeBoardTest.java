package com.company;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {

    private GameBoard gameBoard = new TicTacToeBoard();
    private UserMove move = new UserMove(1,1);
    private Player player = new Player("Cameo", "X");

    @Test
    void shouldAddMoveToBoard(){
        Result expectedResult = new Result.Success(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnErrorIfMoveOutOfBounds(){
        UserMove outOfBoundsMove = new UserMove(1,5);
        Result expectedResult = new Result.Error(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(outOfBoundsMove, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnErrorIfSpaceAlreadyTaken(){
        gameBoard.addMoveToBoard(move, player);
        Result expectedResult = new Result.Error(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldReturnDrawIfBoardFull() {
        Player player0 = new Player("Cameo", "0");
        gameBoard.addMoveToBoard(new UserMove(0,0), player);
        gameBoard.addMoveToBoard(new UserMove(0,1), player0);
        gameBoard.addMoveToBoard(new UserMove(0,2), player);
        gameBoard.addMoveToBoard(new UserMove(1,0), player0);
        gameBoard.addMoveToBoard(new UserMove(1,1), player);
        gameBoard.addMoveToBoard(new UserMove(1,2), player0);
        gameBoard.addMoveToBoard(new UserMove(2,0), player0);
        gameBoard.addMoveToBoard(new UserMove(2,1), player);


        Result expectedResult = new Result.Draw(gameBoard);
        Result actualResult = gameBoard.addMoveToBoard(new UserMove(2,2), player0);

        assertEquals(expectedResult.getStatus(), actualResult.getStatus());
    }

    @Test
    void shouldMatchTokenForWinningCombination(){
        gameBoard.addMoveToBoard(new UserMove(1,0), player);
        gameBoard.addMoveToBoard(new UserMove(1,1), player);
        gameBoard.addMoveToBoard(new UserMove(1,2), player);
        WinningCombination horizontalRow = new WinningCombination(new UserMove(1,0), new UserMove(1,1), new UserMove(1,2));
        assertTrue(gameBoard.tokenMatchAtPosition(horizontalRow, player));
    }

}