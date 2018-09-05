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

    @Disabled
    void shouldReturnDrawIfBoardFull() {
        gameBoard.addMoveToBoard(move, userToken);
        Result expectedResult = new Result(gameBoard.printBoard(), "draw", "Oh no, it's a draw!");

        assertEquals(expectedResult.status, gameBoard.addMoveToBoard(move, userToken).status);
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

}