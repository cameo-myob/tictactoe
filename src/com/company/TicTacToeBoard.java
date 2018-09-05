package com.company;

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

    private boolean isEmptySpace(UserMove move){
        return this.gameBoard[move.x][move.y].trim().isEmpty();
    }
    public Result addMoveToBoard(UserMove move, String userToken){
        if(!moveIsInBoardBounds(move)){
            return new Result(printBoard(), "out of bounds", "Your move must be within the bounds of the board, please try again:");
        }
        if(!isEmptySpace(move)){
            return new Result(printBoard(), "tile full", "There is already a token in that position, please try again:");
        }
        this.gameBoard[move.x][move.y] = userToken;
        if(isFull()){
            return new Result(printBoard(), "draw", "Oh no, it's a draw!");
        }
        return new Result(printBoard(), "success", "Move confirmed, here is the current board:");

    }

    public boolean tokenMatchAtPosition(WinningCombination positions, String token){
        return gameBoard[positions.firstPosition.x][positions.firstPosition.y].equals(token) &&
                gameBoard[positions.secondPosition.x][positions.secondPosition.y].equals(token) &&
                gameBoard[positions.thirdPosition.x][positions.thirdPosition.y].equals(token);

    }

    private boolean moveIsInBoardBounds(UserMove move){
        try {
            this.isEmptySpace(move);
            return true;
        } catch (ArrayIndexOutOfBoundsException error) {
            return false;
        }
    }

    private boolean isFull() {
        for(int row = 0; row < gameBoard.length; row++){
            for(int column = 0; column < gameBoard[row].length; column++){
                if(gameBoard[row][column].trim().isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }
}