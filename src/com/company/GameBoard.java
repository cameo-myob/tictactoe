package com.company;

public class GameBoard {
    private String[][] gameBoard = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
    // gets move
    // checks if move will fit in board
    // adds move to board
    // check if move won game
    // check if move drew game

    public String[][] returnBoard() {
        return this.gameBoard;
    }

    public boolean isValidMove(String userInput){
        String[] userMove = userInput.split(",");
        int xLoc = Integer.parseInt(userMove[0]);
        int yLoc = Integer.parseInt(userMove[1]);
        if(this.gameBoard[xLoc][yLoc] == ""){
            return true;
        } else return false;
    }

    public String[][] addMove(String userInput, String userToken){
        String[] userMove = userInput.split(",");
        int xLoc = (Integer.parseInt(userMove[0]) - 1);
        int yLoc = (Integer.parseInt(userMove[1]) - 1);
        this.gameBoard[xLoc][yLoc] = userToken;
        return this.gameBoard;
    }

    public boolean isWon(){
        if(isHorizontalWin() || isVerticallWin() || isDiagonalWin()){
            return true;
        } else return false;
    }

    private boolean isHorizontalWin(){
        String[][] board = this.gameBoard;
        if(board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]) && !board[0][0].isEmpty()){
            return true;
        } else if (board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]) && !board[0][0].isEmpty()){
            return true;
        } else if (board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]) && !board[0][0].isEmpty()){
            return true;
        } else return false;
    }

    private boolean isVerticallWin(){
        String[][] board = this.gameBoard;
        if(board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]) && !board[0][0].isEmpty()){
            return true;
        } else if (board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]) && !board[0][1].isEmpty()){
            return true;
        } else if (board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]) && !board[0][2].isEmpty()){
            return true;
        } else return false;
    }

    private boolean isDiagonalWin(){
        String[][] board = this.gameBoard;
        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].isEmpty()){
            return true;
        } else if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][2]) && !board[0][2].isEmpty()){
            return true;
        } else return false;
    }


}
