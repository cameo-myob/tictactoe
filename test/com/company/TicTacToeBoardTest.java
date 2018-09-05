package com.company;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {

    private GameBoard gameBoard = new TicTacToeBoard();
    private UserMove move = new UserMove(1,1);
    private String userToken = "X";

    @Test
    void shouldAddMoveToBoard(){
        Result expectedResult = new Result(gameBoard.printBoard(), "success", "Move confirmed, here is the current board:");

        assertEquals(expectedResult.status, gameBoard.addMoveToBoard(move, userToken).status);
    }

    @Test
    void shouldReturnErrorIfMoveOutOfBounds(){
        UserMove outOfBoundsMove = new UserMove(1,5);
        Result expectedResult = new Result(gameBoard.printBoard(), "out of bounds", "Your move must be within the bounds of the board, please try again:");

        assertEquals(expectedResult.status, gameBoard.addMoveToBoard(outOfBoundsMove, userToken).status);
    }

    @Test
    void shouldReturnErrorIfSpaceAlreadyTaken(){
        gameBoard.addMoveToBoard(move, userToken);
        Result expectedResult = new Result(gameBoard.printBoard(), "tile full", "There is already a token in that position, please try again:");

        assertEquals(expectedResult.status, gameBoard.addMoveToBoard(move, userToken).status);
    }

    @Test
    void shouldReturnDrawIfBoardFull() {
        gameBoard.addMoveToBoard(move, userToken);
        String expectedBoard = "|---|---|---|\n";
        expectedBoard += "| 0 | X | 0 |\n";
        expectedBoard += "|---|---|---|\n";
        expectedBoard += "| 0 | X | 0 |\n";
        expectedBoard += "|---|---|---|\n";
        expectedBoard += "| X | 0 | X |\n";
        expectedBoard += "|---|---|---|";

        gameBoard.addMoveToBoard(new UserMove(0,0), "0");
        gameBoard.addMoveToBoard(new UserMove(0,1), "X");
        gameBoard.addMoveToBoard(new UserMove(0,2), "0");
        gameBoard.addMoveToBoard(new UserMove(1,0), "0");
        gameBoard.addMoveToBoard(new UserMove(1,1), "X");
        gameBoard.addMoveToBoard(new UserMove(1,2), "0");
        gameBoard.addMoveToBoard(new UserMove(2,0), "X");
        gameBoard.addMoveToBoard(new UserMove(2,1), "0");

        assertEquals(expectedBoard, gameBoard.addMoveToBoard(new UserMove(2,2), "X").board);
    }

    @Test
    void shouldReturnBoardAsString(){
        gameBoard.addMoveToBoard(move, userToken);
        Result actualResult = gameBoard.addMoveToBoard(move, userToken);

        String displayBoard = "|---|---|---|\n";
        displayBoard += "|   |   |   |\n";
        displayBoard += "|---|---|---|\n";
        displayBoard += "|   | X |   |\n";
        displayBoard += "|---|---|---|\n";
        displayBoard += "|   |   |   |\n";
        displayBoard += "|---|---|---|";

        assertEquals(displayBoard, actualResult.board);
    }

    @Test
    void shouldMatchTokenForWinningCombination(){
        gameBoard.addMoveToBoard(new UserMove(1,0), "X");
        gameBoard.addMoveToBoard(new UserMove(1,1), "X");
        gameBoard.addMoveToBoard(new UserMove(1,2), "X");
        WinningCombination horizontalRow = new WinningCombination(new UserMove(1,0), new UserMove(1,1), new UserMove(1,2));
        assertTrue(gameBoard.tokenMatchAtPosition(horizontalRow, userToken));
    }

}