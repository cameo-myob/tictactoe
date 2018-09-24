package com.company;

import com.company.tictactoe.board.GameBoard;
import com.company.tictactoe.Result;
import com.company.tictactoe.board.GameBoardFactory;
import com.company.tictactoe.board.TicTacToeBoardFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ResultTest {

    @Test
    void shouldCreateResultWithWinStatus() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createWinBoard();
        Result.Status result = new Result.Win(tttBoard).getStatus();

        assertTrue(result.equals(Result.Status.WIN));
    }

    @Test
    void shouldCreateResultWithDrawStatus() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createDrawBoard();
        Result.Status result = new Result.Draw(tttBoard).getStatus();

        assertTrue(result.equals(Result.Status.DRAW));
    }

    @Test
    void shouldCreateResultWithErrorStatus() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createEmptyBoard();
        Result.Status result = new Result.Error(tttBoard).getStatus();

        assertTrue(result.equals(Result.Status.ERROR));
    }

    @Test
    void shouldCreateResultWithSuccessStatus() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createEmptyBoard();
        Result.Status result = new Result.Success(tttBoard).getStatus();

        assertTrue(result.equals(Result.Status.SUCCESS));
    }
}