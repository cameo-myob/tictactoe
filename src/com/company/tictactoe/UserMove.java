package com.company.tictactoe;

public class UserMove {
    public final int x;
    public final int y;

    public UserMove(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other){
        return other instanceof UserMove &&
                this.x == ((UserMove)other).x &&
                this.y == ((UserMove)other).y;
    }
}
