package com.company;

public class MoveParser {

    public static UserMove parse(String input){
        String[] move = input.split(",");
        return new UserMove(Integer.parseInt(move[0]), Integer.parseInt(move[1]));
    }
}
