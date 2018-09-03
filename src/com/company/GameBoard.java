package com.company;

public interface GameBoard {

    String printBoard();
    boolean isEmptySpace(UserMove userInput);
    boolean addMoveToBoard(UserMove userInput, String userToken);
    boolean tokenMatchAtPosition(WinningCombination positions, String userToken);
    boolean isFull();
}
