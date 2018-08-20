package com.company;

// gets move
// checks if move will fit in board
// adds move to board
// check if move won game
// check if move drew game

public class GameBoard {
    private String[][] gameBoard = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    private int remainingMoves = 9;


    public String[][] returnBoard() {
        return this.gameBoard;
    }

    public boolean isValidMove(String userInput){
        String[] userMove = userInput.split(",");
        int xLoc = (Integer.parseInt(userMove[0]) - 1);
        int yLoc = (Integer.parseInt(userMove[1]) - 1);
        if(this.gameBoard[xLoc][yLoc].trim().isEmpty()){
            return true;
        } return false;
    }

    public String[][] addMove(String userInput, String userToken){
        String[] userMove = userInput.split(",");
        int xLoc = (Integer.parseInt(userMove[0]) - 1);
        int yLoc = (Integer.parseInt(userMove[1]) - 1);
        this.gameBoard[xLoc][yLoc] = userToken;
        this.remainingMoves--;
        return this.gameBoard;
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
        } else if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][2]) && !board[0][2].trim().isEmpty()){
            return true;
        } return false;
    }

    public boolean isDraw(){
        if(!isWon() && this.remainingMoves == 0){
            return true;
        } return false;
    }


}
