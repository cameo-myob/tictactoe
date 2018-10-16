package com.company;

import com.company.backend.ServerAdaptor;
import com.company.console.ConsoleAdaptor;
import com.company.tictactoe.Game;
import com.company.tictactoe.IOAdaptor;
import com.company.tictactoe.board.GameBoard;
import com.company.tictactoe.board.GameBoardFactory;
import com.company.tictactoe.board.TicTacToeBoardFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        IOAdaptor console = new ServerAdaptor();
        GameBoardFactory tttBoardFactory = new TicTacToeBoardFactory();
        GameBoard emptyBoard = tttBoardFactory.createEmptyBoard();

        Game ticTacToe = new Game(emptyBoard, console);
        ticTacToe.startGame();
    }


}
