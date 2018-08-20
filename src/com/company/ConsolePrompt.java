package com.company;

import java.util.Scanner;

public class ConsolePrompt implements Prompt{
    Scanner input = new Scanner(System.in);

    public void gameWelcome(){
        System.out.println("Welcome to Tic Tac Toe!");
    }

    public void printBoard(String[][] currentBoard){
        String displayBoard = "|---|---|---|\n";
        displayBoard += "| " + currentBoard[0][0] + " | " + currentBoard[0][1] + " | " + currentBoard[0][2] + " |\n";
        displayBoard += "|---|---|---|\n";
        displayBoard += "| " + currentBoard[1][0] + " | " + currentBoard[1][1] + " | " + currentBoard[1][2] + " |\n";
        displayBoard += "|---|---|---|\n";
        displayBoard += "| " + currentBoard[2][0] + " | " + currentBoard[2][1] + " | " + currentBoard[2][2] + " |\n";
        displayBoard += "|---|---|---|";
        System.out.println(displayBoard);
    }

    public String getUserMove(String currentPlayerToken){
        System.out.print("Enter a coordinate x,y to place your " + currentPlayerToken + " or enter 'q' to quit: ");
        return input.nextLine();
    }

    public void printConfirmedMove(){
        System.out.println("Move confirmed, here is the current board:");
    }

    public void printInvalidMove(){
        System.out.println("There seems to be another piece in this place. Please try again.");
    }

    public void printWin(String currentPlayerToken){
        System.out.println("Congratulations, Player " + currentPlayerToken + " has won the game!");
    }

    public void printDraw(){
        System.out.println("Oh no, it's a draw!");
    }
}
