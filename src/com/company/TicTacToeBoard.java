package com.company;

public class TicTacToeBoard implements GameBoard {
    private String[][] gameBoard = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    private WinChecker winChecker = new WinChecker();

    public String[][] getBoard(){
        return this.gameBoard;
    }

    private boolean isEmptySpace(UserMove move){
        return this.gameBoard[move.x][move.y].trim().isEmpty();
    }

    public Result addMoveToBoard(UserMove move, Player player){

        if(!isInBoardBounds(move) || !isEmptySpace(move)){
            return new Result.Error(this);
        }

        this.gameBoard[move.x][move.y] = player.getToken();

        if(isFull()){
            return new Result.Draw(this);
        }
        if(winChecker.isWinningMove(this, player)){
            return new Result.Win(this);
        }
        return new Result.Success(this);

    }

    public boolean tokenMatchAtPosition(WinningCombination positions, Player player){
        String token = player.getToken();
        return gameBoard[positions.firstPosition.x][positions.firstPosition.y].equals(token) &&
                gameBoard[positions.secondPosition.x][positions.secondPosition.y].equals(token) &&
                gameBoard[positions.thirdPosition.x][positions.thirdPosition.y].equals(token);

    }

    private boolean isInBoardBounds(UserMove move){
        return (move.x >= 0 && move.x <= gameBoard.length - 1) &&
                (move.y >= 0 && move.y <= gameBoard[0].length - 1);
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