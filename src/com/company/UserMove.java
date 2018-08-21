// not implemented

package com.company;

public class UserMove {
    private int x;
    private int y;

    public UserMove(String input){
        String[] coOrdinates = input.split(",");
        this.x = Integer.parseInt(coOrdinates[0]);
        this.y = Integer.parseInt(coOrdinates[1]);
    }

    public int[] getMove() {
        int[] move = {this.x, this.y};
        return move;
    }
}
