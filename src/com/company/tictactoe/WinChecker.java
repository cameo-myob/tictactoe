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


    public boolean isWinningMove(GameBoard board){
        if(isHorizontalWin(board) || isVerticalWin(board) || isDiagonalWin(board)){
            return true;
        } return false;
    }

    private boolean isHorizontalWin(GameBoard gameBoard){
        if(tokenMatchAtPosition(gameBoard, horizontalTopRow) ||
                tokenMatchAtPosition(gameBoard, horizontalMiddleRow) ||
                tokenMatchAtPosition(gameBoard, horizontalBottomRow)){
            return true;
        }
        return false;
    }

    private boolean isVerticalWin(GameBoard gameBoard){
        if(tokenMatchAtPosition(gameBoard, verticalLeftColumn) ||
                tokenMatchAtPosition(gameBoard, verticalMiddleColumn) ||
                tokenMatchAtPosition(gameBoard, verticalRightColumn)){
            return true;
        }
        return false;
    }

    private boolean isDiagonalWin(GameBoard gameBoard){
        if(tokenMatchAtPosition(gameBoard, leftDiagonal) ||
                tokenMatchAtPosition(gameBoard, rightDiagonal)){
            return true;
        }
        return false;
    }

    private boolean tokenMatchAtPosition(GameBoard gameBoard, WinningCombination positions){
        String[][] board = gameBoard.getBoard();
        String position1 = board[positions.firstPosition.x - 1][positions.firstPosition.y - 1];
        String position2 = board[positions.secondPosition.x - 1][positions.secondPosition.y - 1];
        String position3 = board[positions.thirdPosition.x - 1][positions.thirdPosition.y - 1];

        return position1.equals(position2) && position2.equals(position3) && !position1.trim().isEmpty();
    }

}
