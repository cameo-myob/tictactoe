package com.company.tictactoe;

import com.company.tictactoe.board.GameBoard;

public class WinChecker {
    private WinningCombination horizontalTopRow = new WinningCombination(new UserMove(1,1), new UserMove(1,2), new UserMove(1,3));
    private WinningCombination horizontalMiddleRow = new WinningCombination(new UserMove(2,1), new UserMove(2,2), new UserMove(2,3));
    private WinningCombination horizontalBottomRow = new WinningCombination(new UserMove(3,1), new UserMove(3,2), new UserMove(3,3));
    private WinningCombination verticalLeftColumn = new WinningCombination(new UserMove(1,1), new UserMove(2,1), new UserMove(3,1));
    private WinningCombination verticalMiddleColumn = new WinningCombination(new UserMove(1,2), new UserMove(2,2), new UserMove(3,2));
    private WinningCombination verticalRightColumn = new WinningCombination(new UserMove(1,3), new UserMove(2,3), new UserMove(3,3));
    private WinningCombination leftDiagonal = new WinningCombination(new UserMove(1,3), new UserMove(2,2), new UserMove(3,1));
    private WinningCombination rightDiagonal = new WinningCombination(new UserMove(1,1), new UserMove(2,2), new UserMove(3,3));


    public boolean isWinningMove(GameBoard board, Player player){
        if(isHorizontalWin(board, player) || isVerticalWin(board, player) || isDiagonalWin(board, player)){
            return true;
        } return false;
    }

    private boolean isHorizontalWin(GameBoard gameBoard, Player player){
        if(gameBoard.tokenMatchAtPosition(horizontalTopRow, player) ||
                gameBoard.tokenMatchAtPosition(horizontalMiddleRow, player) ||
                gameBoard.tokenMatchAtPosition(horizontalBottomRow, player)){
            return true;
        }
        return false;
    }

    private boolean isVerticalWin(GameBoard gameBoard, Player player){
        if(gameBoard.tokenMatchAtPosition(verticalLeftColumn, player) ||
                gameBoard.tokenMatchAtPosition(verticalMiddleColumn, player) ||
                gameBoard.tokenMatchAtPosition(verticalRightColumn, player)){
            return true;
        }
        return false;
    }

    private boolean isDiagonalWin(GameBoard gameBoard, Player player){
        if(gameBoard.tokenMatchAtPosition(leftDiagonal, player) ||
                gameBoard.tokenMatchAtPosition(rightDiagonal, player)){
            return true;
        }
        return false;
    }

}
