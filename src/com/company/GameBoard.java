package com.company;

public interface GameBoard {

    String[][] returnBoard();
    boolean isValidMove(String userInput);
    String[][] addMove(String userInput, String userToken);
    boolean isWon();
    boolean isDraw();
}
