package com.company;

public class Player {
    private String playerName;
    private String playerToken;

    public Player(String name, String token){
        this.playerName = name;
        this.playerToken = token;
    }

    public String getPlayerName(){
        return playerName;
    }

    public String getPlayerToken(){
        return playerToken;
    }
}
