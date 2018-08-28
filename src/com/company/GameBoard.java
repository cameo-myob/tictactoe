package com.company;

public interface GameBoard {

    String printBoard();
    boolean isEmptySpace(UserMove userInput);
    boolean addMove(UserMove userInput, String userToken);
    boolean isWon();
    boolean isDraw();
    boolean running();
}
