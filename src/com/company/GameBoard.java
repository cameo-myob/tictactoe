package com.company;

public interface GameBoard {

    Result addMoveToBoard(UserMove userInput, Player player);
    boolean tokenMatchAtPosition(WinningCombination horizontalTopRow, Player player);
    String[][] getBoard();
}
