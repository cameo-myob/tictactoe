package com.company;

import com.company.backend.JavaServer;
import com.company.tictactoe.Player;
import com.company.console.ConsolePrompt;
import com.company.tictactoe.Game;
import com.company.tictactoe.GameInterface;
import com.company.tictactoe.board.GameBoard;
import com.company.tictactoe.board.GameBoardFactory;
import com.company.tictactoe.board.TicTacToeBoardFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GameInterface backend = GameInterface.SERVER;

        switch(backend){
            case CONSOLE:{
                ConsolePrompt prompt = new ConsolePrompt();
                Player player1 = prompt.getPlayerInfo();
                Player player2 = prompt.getPlayerInfo();
                GameBoardFactory tttBoardFactory = new TicTacToeBoardFactory();
                GameBoard emptyBoard = tttBoardFactory.createEmptyBoard();
                Game ticTacToe = new Game(emptyBoard, prompt, player1, player2);
                ticTacToe.startGame();
                break;
            }
            case SERVER:{
                JavaServer.start();
                break;
            }
        }


    }
}
