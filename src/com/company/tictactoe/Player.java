package com.company.tictactoe;

public class Player {
    private String playerName;
    private String playerToken;

    public Player(String name, String token){
        this.playerName = name;
        this.playerToken = token;
    }

    public String getName(){
        return playerName;
    }

    public String getToken(){
        return playerToken;
    }
}
