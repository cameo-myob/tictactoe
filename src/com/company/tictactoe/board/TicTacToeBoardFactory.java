package com.company.tictactoe.board;

public class TicTacToeBoardFactory extends GameBoardFactory {
    public GameBoard createWinBoard(){
        return new TicTacToeBoard(new String[][] {{"X", "X", "X"}, {" ", " ", " "}, {" ", " ", " "}});
    }
    public GameBoard createDrawBoard(){
        return new TicTacToeBoard(new String[][] {{"X", "0", "X"}, {"0", "X", "0"}, {"0", "X", "0"}});
    }

    public GameBoard createEmptyBoard(){
        return new TicTacToeBoard(new String[][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}});
    }

    public GameBoard createTestBoard(){
        return new TicTacToeBoard(new String[][] {{"X", "X", " "}, {"0", "0", "X"}, {"X", "X", "0"}});
    }
}