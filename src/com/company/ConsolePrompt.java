package com.company;
import java.util.Scanner;

public class ConsolePrompt implements Prompt{
    private Scanner input = new Scanner(System.in);

    public void gameWelcome(){
        System.out.println("Welcome to Tic Tac Toe!");
    }

//    not implemented
//    public boolean morePlayers(){
//        System.out.println("Would you like to add another player? y/n ");
//        if(input.nextLine().equals("y")){
//            return true;
//        }
//        return false;
//    }
//
//    public Player getPlayer(){
//        System.out.println("Please enter player name: ");
//        String playerName = input.nextLine();
//        System.out.println("Please choose your game token: ");
//        String playerToken = input.nextLine();
//        return new Player(playerName, playerToken);
//    }

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

    public String getUserMove(String currentPlayerName, String currentPlayerToken){
        System.out.print(currentPlayerName + ", enter a coordinate x,y to place your " + currentPlayerToken + " or enter 'q' to quit: ");
        return input.nextLine();
    }

    public void printConfirmedMove(){
        System.out.println("Move confirmed, here is the current board:");
    }

    public void printInvalidMove(){
        System.out.println("There seems to be another piece in this place. Please try again.");
    }

    public void printWin(String currentPlayerName){
        System.out.println("Congratulations, " + currentPlayerName + " has won the game!");
    }

    public void printDraw(){
        System.out.println("Oh no, it's a draw!");
    }
}
