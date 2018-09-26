package com.company.tictactoe.board;

import com.company.tictactoe.Result;
import com.company.tictactoe.UserMove;
import com.company.tictactoe.WinningCombination;

public abstract class GameBoard {

    public abstract Result addMoveToBoard(UserMove userInput);
    public abstract boolean tokenMatchAtPosition(WinningCombination winningCombination);
    public abstract String[][] getBoard();
}
