package com.company;

public class TicTacToeBoardFactory extends GameBoardFactory {
    public GameBoard createBoard(String input){
        if(input.equalsIgnoreCase("win")){
            return new TicTacToeBoard(new String[][] {{"X", "X", "X"}, {" ", " ", " "}, {" ", " ", " "}});
        } else if(input.equalsIgnoreCase("draw")){
            return new TicTacToeBoard(new String[][] {{"X", "0", "X"}, {"0", "X", "0"}, {"0", "X", "0"}});
        }else if(input.equalsIgnoreCase("empty")){
            return new TicTacToeBoard(new String[][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}});
        } else if(input.equalsIgnoreCase("test")){
            return new TicTacToeBoard(new String[][] {{"X", "X", " "}, {"0", "0", "X"}, {"X", "X", "0"}});
        }
        return new TicTacToeBoard(new String[][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}});
    }


}