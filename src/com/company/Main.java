package com.company;

import com.company.backend.handler.AddMoveHandler;
import com.company.tictactoe.Player;
import com.company.tictactoe.prompt.ConsolePrompt;
import com.company.tictactoe.prompt.Prompt;
import com.company.tictactoe.Game;
import com.company.tictactoe.GameInterface;
import com.company.tictactoe.board.GameBoard;
import com.company.tictactoe.board.GameBoardFactory;
import com.company.tictactoe.board.TicTacToeBoardFactory;
import com.company.tictactoe.prompt.ServerPrompt;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws IOException {
        GameInterface backend = GameInterface.CONSOLE;
        Prompt prompt = new ConsolePrompt();

        switch(backend){
            case CONSOLE:{
                 break;
            }
            case SERVER:{
                HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
                server.createContext("/addmove", new AddMoveHandler());
                server.start();

                prompt = new ServerPrompt();
            }
        }

        Player player1 = new Player("Cameo", "X");
        Player player2 = new Player("Test", "O");
        GameBoardFactory tttBoardFactory = new TicTacToeBoardFactory();
        GameBoard emptyBoard = tttBoardFactory.createEmptyBoard();
        Game ticTacToe = new Game(emptyBoard, prompt, player1, player2);
        ticTacToe.start();
    }
}
