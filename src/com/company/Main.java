package com.company;

import com.company.console.ConsolePrompt;
import com.company.tictactoe.Game;
import com.company.tictactoe.board.GameBoard;
import com.company.tictactoe.board.GameBoardFactory;
import com.company.tictactoe.board.TicTacToeBoardFactory;

public class Main {

    public static void main(String[] args){

        ConsolePrompt userPrompt = new ConsolePrompt();
        GameBoardFactory tttBoardFactory = new TicTacToeBoardFactory();
        GameBoard emptyBoard = tttBoardFactory.createEmptyBoard();

        Game ticTacToe = new Game(emptyBoard, userPrompt);
        ticTacToe.startGame();
    }


}
