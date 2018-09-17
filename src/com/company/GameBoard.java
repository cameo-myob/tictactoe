package com.company;

public abstract class GameBoard {

    abstract Result addMoveToBoard(UserMove userInput, Player player);
    abstract boolean tokenMatchAtPosition(WinningCombination horizontalTopRow, Player player);
    abstract String[][] getBoard();
}
