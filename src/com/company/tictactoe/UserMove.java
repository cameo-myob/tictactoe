package com.company.tictactoe;

public class UserMove {
    public final int x;
    public final int y;
    public final String token;

    public UserMove(int x, int y, String token){
        this.x = x;
        this.y = y;
        this.token = token;
    }

    @Override
    public boolean equals(Object other){
        return other instanceof UserMove &&
                this.x == ((UserMove)other).x &&
                this.y == ((UserMove)other).y &&
                this.token.equals(((UserMove) other).token);
    }
}
