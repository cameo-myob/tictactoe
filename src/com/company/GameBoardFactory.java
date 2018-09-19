package com.company;

public abstract class GameBoardFactory {
    abstract GameBoard createWinBoard();
    abstract GameBoard createDrawBoard();
    abstract GameBoard createEmptyBoard();
    abstract GameBoard createTestBoard();
}
