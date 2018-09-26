package com.company.tictactoe.prompt;

import com.company.tictactoe.Player;
import com.company.tictactoe.Result;

public class ServerPrompt implements Prompt{
    public void print(Result output){

    };
    public void print(Player currentPlayer){

    };
    public void print(String output){

    };
    public String getInput(){
        return "hello";
    };

    public Player getPlayerInfo(){
        return new Player("hello", "hello");
    }
}