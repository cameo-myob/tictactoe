package com.company;


public class Main {

    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        board.addMove("1,1", "X");
        board.addMove("2,2", "X");
        board.addMove("3,3", "X");
        System.out.println(board.isWon());
    }
}
