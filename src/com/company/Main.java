package com.company;

import com.company.backend.JavaServer;
import com.company.tictactoe.Player;
import com.company.tictactoe.prompt.ConsolePrompt;
import com.company.tictactoe.prompt.Prompt;
import com.company.tictactoe.Game;
import com.company.tictactoe.GameInterface;
import com.company.tictactoe.board.GameBoard;
import com.company.tictactoe.board.GameBoardFactory;
import com.company.tictactoe.board.TicTacToeBoardFactory;
import com.company.tictactoe.prompt.ServerPrompt;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GameInterface backend = GameInterface.CONSOLE;
        Prompt prompt = new ConsolePrompt();
        Player player1 = new Player("Cameo", "X");
        Player player2 = new Player("Test", "O");

        switch(backend){
            case CONSOLE:{
                 player1 = ((ConsolePrompt) prompt).getPlayerInfo();
                 player2 = ((ConsolePrompt) prompt).getPlayerInfo();
                 break;
            }
            case SERVER:{
                JavaServer.start();
                prompt = new ServerPrompt();
                break;
            }
        }

        GameBoardFactory tttBoardFactory = new TicTacToeBoardFactory();
        GameBoard emptyBoard = tttBoardFactory.createEmptyBoard();
        Game ticTacToe = new Game(emptyBoard, prompt, player1, player2);
        ticTacToe.startGame();
    }
}
