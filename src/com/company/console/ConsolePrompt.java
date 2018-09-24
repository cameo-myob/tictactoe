package com.company.console;
import com.company.tictactoe.Player;
import com.company.tictactoe.Result;

import java.util.Scanner;

public class ConsolePrompt implements Prompt {


    private Scanner input = new Scanner(System.in);
    private StringBoardFormatter boardFormatter = new StringBoardFormatter();

    public void print(Result result){
        System.out.println(result.getStatus().getMessage());
        System.out.println(boardFormatter.format(result));
    }

    public void print(Player currentPlayer){
        String playerName = currentPlayer.getName();
        String playerToken = currentPlayer.getToken();

        System.out.println(playerName + ", enter a coordinate x,y to place your " + playerToken + " or enter 'q' to quit: ");
    }

    public void print(String output){
        System.out.println(output);
    }

    public String getInput(){
        return input.nextLine();
    }
}
