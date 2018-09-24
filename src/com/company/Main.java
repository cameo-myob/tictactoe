package com.company;

import com.company.backend.handler.TestHandler;
import com.company.console.ConsolePrompt;
import com.company.tictactoe.Game;
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
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new TestHandler());
        server.start();

        ConsolePrompt userPrompt = new ConsolePrompt();
        GameBoardFactory tttBoardFactory = new TicTacToeBoardFactory();
        GameBoard emptyBoard = tttBoardFactory.createEmptyBoard();
        Player player1 = getPlayerInfo(userPrompt);
        Player player2 = getPlayerInfo(userPrompt);

        Game ticTacToe = new Game(emptyBoard, userPrompt, player1, player2);
        Result result;
        do {
            result = ticTacToe.gameLoop();
        } while(result.getStatus().equals(Result.Status.SUCCESS) || result.getStatus().equals(Result.Status.ERROR));
    }

    private static Player getPlayerInfo(ConsolePrompt prompt){
        prompt.print("Please enter Player name:");
        String playerName = prompt.getInput();
        prompt.print("Please enter Player token:");
        String playerToken = prompt.getInput();
        return new Player(playerName, playerToken);
    }
}
