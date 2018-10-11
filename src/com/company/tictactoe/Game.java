package com.company.tictactoe;

import com.company.tictactoe.board.GameBoard;

import java.io.IOException;

public class Game {
    private Player currentPlayer;
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private IOAdaptor adaptor;

    public Game(GameBoard board, IOAdaptor adaptor) {
        this.gameBoard = board;
        this.adaptor = adaptor;
    }

    public void startGame() throws InterruptedException, IOException {
        this.player1 = adaptor.getPlayerInfo();
        System.out.println(player1.getName());
        this.player2 = adaptor.getPlayerInfo();
        this.currentPlayer = player1;

        Result result;
        do {
            result = gameLoop();
            adaptor.outputResult(result);
        } while(result.getStatus().equals(Result.Status.SUCCESS) || result.getStatus().equals(Result.Status.ERROR));
        System.exit(0);
    }

    private Result gameLoop() throws InterruptedException {
        UserMove currentMove = adaptor.getValidMove(currentPlayer);
        Result result = gameBoard.addMoveToBoard(currentMove, currentPlayer);
        if (result.getStatus().equals(Result.Status.SUCCESS)) { swapPlayer();}
        return result;
    }

    private void swapPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
}
