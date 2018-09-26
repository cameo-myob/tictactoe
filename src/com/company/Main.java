package com.company;

import com.company.backend.handler.AddMoveHandler;
import com.company.tictactoe.prompt.ConsolePrompt;
import com.company.tictactoe.prompt.Prompt;
import com.company.tictactoe.Game;
import com.company.tictactoe.GameInterface;
import com.company.tictactoe.Player;
import com.company.tictactoe.Result;
import com.company.tictactoe.board.GameBoard;
import com.company.tictactoe.board.GameBoardFactory;
import com.company.tictactoe.board.TicTacToeBoardFactory;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws IOException {
        run(GameInterface.SERVER);
    }

    public static void run(GameInterface game) throws IOException {
        Prompt prompt;
        switch(game){
            case CONSOLE:{
                 prompt = new ConsolePrompt();
            }
            case SERVER:{
                HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
                server.createContext("/addmove", new AddMoveHandler());
                server.start();
                prompt = new ConsolePrompt();
            }
        }

        GameBoardFactory tttBoardFactory = new TicTacToeBoardFactory();
        GameBoard emptyBoard = tttBoardFactory.createEmptyBoard();
        Player player1 = prompt.getPlayerInfo();
        Player player2 = prompt.getPlayerInfo();
        Game ticTacToe = new Game(emptyBoard, prompt, player1, player2);

        Result result;
        do {
            result = ticTacToe.gameLoop();
        } while(result.getStatus().equals(Result.Status.SUCCESS) || result.getStatus().equals(Result.Status.ERROR));
    }
}
