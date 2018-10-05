package com.company;

import com.company.tictactoe.*;
import com.company.tictactoe.board.GameBoard;
import com.company.tictactoe.board.GameBoardFactory;
import com.company.tictactoe.board.TicTacToeBoardFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToeBoardTest {

    @Test
    void shouldAddMoveToBoard(){
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createEmptyBoard();
        UserMove move = new UserMove(1,1);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Success(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnErrorIfMoveOutOfBounds(){
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createEmptyBoard();
        Player player = new Player("Cameo", "X");
        UserMove outOfBoundsMove = new UserMove(1,5);

        Result expectedResult = new Result.Error(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(outOfBoundsMove, player);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnErrorIfSpaceAlreadyTaken(){
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createTestBoard();
        UserMove move = new UserMove(2,2);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Error(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnWinForTopHorizontalRow() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createTestBoard();
        UserMove move = new UserMove(1,3);
        Player player = new Player("Cameo", "X");

        Result expectedResult = new Result.Win(tttBoard);
        Result actualResult = tttBoard.addMoveToBoard(move, player);

        assertEquals(expectedResult, actualResult);
    }
}