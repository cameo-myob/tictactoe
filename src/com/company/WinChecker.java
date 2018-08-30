package com.company;

public class WinChecker {
    private WinningCombination horizontalTopRow = new WinningCombination(new UserMove(0,0), new UserMove(0,1), new UserMove(0,2));
    private WinningCombination horizontalMiddleRow = new WinningCombination(new UserMove(1,0), new UserMove(1,1), new UserMove(1,2));
    private WinningCombination horizontalBottomRow = new WinningCombination(new UserMove(2,0), new UserMove(2,1), new UserMove(2,2));
    private WinningCombination verticalLeftColumn = new WinningCombination(new UserMove(0,0), new UserMove(1,0), new UserMove(2,0));
    private WinningCombination verticalMiddleColumn = new WinningCombination(new UserMove(0,1), new UserMove(1,1), new UserMove(2,1));
    private WinningCombination verticalRightColumn = new WinningCombination(new UserMove(0,2), new UserMove(1,2), new UserMove(2,2));
    private WinningCombination leftDiagonal = new WinningCombination(new UserMove(0,2), new UserMove(1,1), new UserMove(2,0));
    private WinningCombination rightDiagonal = new WinningCombination(new UserMove(0,0), new UserMove(1,1), new UserMove(2,2));

    public boolean isWinningMove(GameBoard board, String token){
        if(isHorizontalWin(board, token) || isVerticalWin(board, token) || isDiagonalWin(board, token)){
            return true;
        } return false;
    }

    private boolean isHorizontalWin(GameBoard gameBoard, String token){
        if(gameBoard.tokenMatchAtPosition(horizontalTopRow, token) ||
                gameBoard.tokenMatchAtPosition(horizontalMiddleRow, token) ||
                gameBoard.tokenMatchAtPosition(horizontalBottomRow, token)){
            return true;
        }
        return false;
    }

    private boolean isVerticalWin(GameBoard gameBoard, String token){
        if(gameBoard.tokenMatchAtPosition(verticalLeftColumn, token) ||
                gameBoard.tokenMatchAtPosition(verticalMiddleColumn, token) ||
                gameBoard.tokenMatchAtPosition(verticalRightColumn, token)){
            return true;
        }
        return false;
    }

    private boolean isDiagonalWin(GameBoard gameBoard, String token){
        if(gameBoard.tokenMatchAtPosition(leftDiagonal, token) ||
                gameBoard.tokenMatchAtPosition(rightDiagonal, token)){
            return true;
        }
        return false;
    }

}
