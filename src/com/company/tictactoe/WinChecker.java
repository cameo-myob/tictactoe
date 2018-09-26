package com.company.tictactoe;

import com.company.tictactoe.board.GameBoard;

public class WinChecker {
    private WinningCombination horizontalTopRow = new WinningCombination(new UserMove(1,1, ""), new UserMove(1,2, ""), new UserMove(1,3, ""));
    private WinningCombination horizontalMiddleRow = new WinningCombination(new UserMove(2,1, ""), new UserMove(2,2, ""), new UserMove(2,3, ""));
    private WinningCombination horizontalBottomRow = new WinningCombination(new UserMove(3,1, ""), new UserMove(3,2, ""), new UserMove(3,3, ""));
    private WinningCombination verticalLeftColumn = new WinningCombination(new UserMove(1,1, ""), new UserMove(2,1, ""), new UserMove(3,1, ""));
    private WinningCombination verticalMiddleColumn = new WinningCombination(new UserMove(1,2, ""), new UserMove(2,2, ""), new UserMove(3,2, ""));
    private WinningCombination verticalRightColumn = new WinningCombination(new UserMove(1,3, ""), new UserMove(2,3, ""), new UserMove(3,3, ""));
    private WinningCombination leftDiagonal = new WinningCombination(new UserMove(1,3, ""), new UserMove(2,2, ""), new UserMove(3,1, ""));
    private WinningCombination rightDiagonal = new WinningCombination(new UserMove(1,1, ""), new UserMove(2,2, ""), new UserMove(3,3, ""));


    public boolean isWinningMove(GameBoard board){
        if(isHorizontalWin(board) || isVerticalWin(board) || isDiagonalWin(board)){
            return true;
        } return false;
    }

    private boolean isHorizontalWin(GameBoard gameBoard){
        if(gameBoard.tokenMatchAtPosition(horizontalTopRow) ||
                gameBoard.tokenMatchAtPosition(horizontalMiddleRow) ||
                gameBoard.tokenMatchAtPosition(horizontalBottomRow)){
            return true;
        }
        return false;
    }

    private boolean isVerticalWin(GameBoard gameBoard){
        if(gameBoard.tokenMatchAtPosition(verticalLeftColumn) ||
                gameBoard.tokenMatchAtPosition(verticalMiddleColumn) ||
                gameBoard.tokenMatchAtPosition(verticalRightColumn)){
            return true;
        }
        return false;
    }

    private boolean isDiagonalWin(GameBoard gameBoard){
        if(gameBoard.tokenMatchAtPosition(leftDiagonal) ||
                gameBoard.tokenMatchAtPosition(rightDiagonal)){
            return true;
        }
        return false;
    }

}
