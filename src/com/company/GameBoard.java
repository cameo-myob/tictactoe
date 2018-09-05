package com.company;

public interface GameBoard {

    String printBoard();
    Result addMoveToBoard(UserMove userInput, String userToken);
    boolean tokenMatchAtPosition(WinningCombination horizontalTopRow, String token);
}
