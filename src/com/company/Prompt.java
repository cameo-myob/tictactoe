package com.company;

public interface Prompt {
    void gameWelcome();
    void printBoard(String[][] currentBoard);
    String getUserMove(String currentPlayerName, String currentPlayerToken);
    void printConfirmedMove();
    void printInvalidMove();
    void printWin(String currentPlayerToken);
    void printDraw();
}
