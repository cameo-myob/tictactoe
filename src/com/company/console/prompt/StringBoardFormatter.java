package com.company.console.prompt;

public class StringBoardFormatter {

    public String format(String[][] board){
        String displayBoard = "|---|---|---|\n";
        displayBoard += "| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |\n";
        displayBoard += "|---|---|---|\n";
        displayBoard += "| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |\n";
        displayBoard += "|---|---|---|\n";
        displayBoard += "| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |\n";
        displayBoard += "|---|---|---|";
        return displayBoard;

    }

}
