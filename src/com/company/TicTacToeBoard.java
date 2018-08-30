package com.company;

// gets move
// checks if move will fit in board
// adds move to board
// check if move won game
// check if move drew game

public class TicTacToeBoard implements GameBoard {
    private String[][] gameBoard = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};


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

    public boolean addMoveToBoard(UserMove move, String userToken){
        if(this.isEmptySpace(move)){
            this.gameBoard[move.x][move.y] = userToken;
            return true;
        } return false;
    }

    public boolean tokenMatchAtPosition(WinningCombination positions, String token){
        if(gameBoard[positions.firstPosition.x][positions.firstPosition.y].equals(token) &&
                gameBoard[positions.secondPosition.x][positions.secondPosition.y].equals(token) &&
                gameBoard[positions.thirdPosition.x][positions.thirdPosition.y].equals(token)){
            return true;
        }
        return false;
    }
}
