package com.company;

public class UserMove {
    private int x;
    private int y;

    public UserMove(String input){
        String[] coOrds = input.split(",");
        this.x = Integer.parseInt(coOrds[0]);
        this.y = Integer.parseInt(coOrds[1]);
    }

    public int[] getMove() {
        int[] move = {this.x, this.y};
        return move;
    }
}
