package com.company;

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