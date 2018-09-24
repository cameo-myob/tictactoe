package com.company.tictactoe.board;

public abstract class GameBoardFactory {
    public abstract GameBoard createWinBoard();
    public abstract GameBoard createDrawBoard();
    public abstract GameBoard createEmptyBoard();
    public abstract GameBoard createTestBoard();
}
