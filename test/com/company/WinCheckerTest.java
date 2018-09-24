package com.company;

import com.company.tictactoe.Player;
import com.company.tictactoe.WinChecker;
import com.company.tictactoe.board.GameBoard;
import com.company.tictactoe.board.GameBoardFactory;
import com.company.tictactoe.board.TicTacToeBoardFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinCheckerTest {

    @Test
    void shouldReturnTrueIfWinningMove() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createWinBoard();
        Player player = new Player("Cameo", "X");
        WinChecker checker = new WinChecker();

        boolean isWinningMove = checker.isWinningMove(tttBoard, player);

        assertTrue(isWinningMove);
    }

    @Test
    void shouldReturnFalseIfNotWinningMove() {
        GameBoardFactory boardFactory = new TicTacToeBoardFactory();
        GameBoard tttBoard = boardFactory.createDrawBoard();
        Player player = new Player("Cameo", "X");
        WinChecker checker = new WinChecker();

        boolean isWinningMove = checker.isWinningMove(tttBoard, player);

        assertFalse(isWinningMove);
    }
}