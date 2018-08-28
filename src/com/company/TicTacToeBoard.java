package com.company;

// gets move
// checks if move will fit in board
// adds move to board
// check if move won game
// check if move drew game

public class TicTacToeBoard implements GameBoard {
    private String[][] gameBoard = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    private int remainingMoves = 9;


    public String printBoard() {
        String displayBoard = "|---|---|---|\n";
        displayBoard += "| " + gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2] + " |\n";
        displayBoard += "|---|---|---|\n";
        displayBoard += "| " + gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2] + " |\n";
        displayBoard += "|---|---|---|\n";
        displayBoard += "| " + gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2] + " |\n";
        displayBoard += "|---|---|---|";
        return displayBoard;
    }

    public boolean isEmptySpace(UserMove move){
        if(this.gameBoard[move.x][move.y].trim().isEmpty()){
            return true;
        } return false;
    }

    public boolean addMove(UserMove move, String userToken){
        if(this.isEmptySpace(move)){
            this.gameBoard[move.x][move.y] = userToken;
            this.remainingMoves--;
            return true;
        } return false;
    }

    public boolean running(){
        if(isWon() || isDraw()){
            return false;
        } return true;
    }

    public boolean isWon(){
        if(isHorizontalWin() || isVerticalWin() || isDiagonalWin()){
            return true;
        } return false;
    }

    private boolean isHorizontalWin(){
        String[][] board = this.gameBoard;
        if(board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]) && !board[0][0].trim().isEmpty()){
            return true;
        } else if (board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]) && !board[1][0].trim().isEmpty()){
            return true;
        } else if (board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]) && !board[2][0].trim().isEmpty()){
            return true;
        } return false;
    }

    private boolean isVerticalWin(){
        String[][] board = this.gameBoard;
        if(board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]) && !board[0][0].trim().isEmpty()){
            return true;
        } else if (board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]) && !board[0][1].trim().isEmpty()){
            return true;
        } else if (board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]) && !board[0][2].trim().isEmpty()){
            return true;
        } return false;
    }

    private boolean isDiagonalWin(){
        String[][] board = this.gameBoard;
        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].trim().isEmpty()){
            return true;
        } else if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].trim().isEmpty()){
            return true;
        } return false;
    }

    public boolean isDraw(){
        if(!isWon() && this.remainingMoves == 0){
            return true;
        } return false;
    }


}
