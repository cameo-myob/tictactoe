package com.company;

import com.company.tictactoe.Player;
import com.company.tictactoe.Result;
import com.company.tictactoe.UserMove;
import com.company.tictactoe.WinningCombination;
import com.company.tictactoe.board.GameBoard;
import com.company.tictactoe.board.GameBoardFactory;
import com.company.tictactoe.board.TicTacToeBoardFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicTacToeBoardTest {

    @Test
    void shouldAddMoveToBoard(){
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createEmptyBoard();
        UserMove move = new UserMove(1,1, "X");

        Result expectedResult = new Result.Success(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(move);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnErrorIfMoveOutOfBounds(){
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createEmptyBoard();
        UserMove outOfBoundsMove = new UserMove(1,5, "X");

        Result expectedResult = new Result.Error(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(outOfBoundsMove);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnErrorIfSpaceAlreadyTaken(){
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createTestBoard();
        UserMove move = new UserMove(2,2, "X");

        Result expectedResult = new Result.Error(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(move);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnDrawIfBoardFull() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createTestBoard();
        UserMove move = new UserMove(1,3, "X");

        Result expectedResult = new Result.Draw(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(move);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldMatchTokenForWinningCombination(){
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createWinBoard();

        WinningCombination horizontalRow = new WinningCombination(new UserMove(1,1, "X"), new UserMove(1,2, "X"), new UserMove(1,3, "X"));

        assertTrue(tttBoard.tokenMatchAtPosition(horizontalRow));
    }

    @Test
    void shouldReturnWinForTopHorizontalRow() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createTestBoard();
        UserMove move = new UserMove(1,3, "X");

        Result expectedResult = new Result.Win(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(move);

        assertEquals(expectedResult, actualResult);
    }
}