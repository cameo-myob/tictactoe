package com.company;

public class TicTacToeBoard extends GameBoard {
    private String[][] gameBoard;
    private WinChecker winChecker = new WinChecker();

    public TicTacToeBoard(String[][] board){
        this.gameBoard = board;
    }

    public String[][] getBoard(){
        return this.gameBoard;
    }

    private boolean isEmptySpace(UserMove move){
        return this.gameBoard[move.x - 1][move.y - 1].trim().isEmpty();
    }

    public Result addMoveToBoard(UserMove move, Player player){

        if(!isInBoardBounds(move) || !isEmptySpace(move)){
            return new Result.Error(this);
        }

        this.gameBoard[move.x - 1][move.y - 1] = player.getToken();

        if(winChecker.isWinningMove(this, player)){
            return new Result.Win(this);
        }

        if(isFull()){
            return new Result.Draw(this);
        }

        return new Result.Success(this);
    }

    public boolean tokenMatchAtPosition(WinningCombination positions, Player player){
        String token = player.getToken();
        return gameBoard[positions.firstPosition.x - 1][positions.firstPosition.y - 1].equals(token) &&
                gameBoard[positions.secondPosition.x - 1][positions.secondPosition.y - 1].equals(token) &&
                gameBoard[positions.thirdPosition.x - 1][positions.thirdPosition.y - 1].equals(token);
    }

    private boolean isInBoardBounds(UserMove move) {
        return (move.x >= 1 && move.x <= gameBoard.length) &&
                (move.y >= 1 && move.y <= gameBoard[0].length);
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