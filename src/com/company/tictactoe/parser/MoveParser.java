package com.company.tictactoe.parser;

import com.company.tictactoe.UserMove;

public class MoveParser {

    public static UserMove parse(String coords, String token){
        String[] move = coords.split(",");
        return new UserMove(Integer.parseInt(move[0]), Integer.parseInt(move[1]), token);
    }
}
