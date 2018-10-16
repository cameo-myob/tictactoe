package com.company.tictactoe.board;

import com.company.tictactoe.Player;
import com.company.tictactoe.Result;
import com.company.tictactoe.UserMove;

public abstract class GameBoard {

    public abstract Result addMoveToBoard(UserMove userInput, Player player);
    public abstract String[][] getBoard();
}
