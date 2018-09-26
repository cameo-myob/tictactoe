package com.company.tictactoe;

import com.company.tictactoe.prompt.Prompt;
import com.company.tictactoe.board.GameBoard;
import com.company.tictactoe.parser.MoveParser;

public class Game {
    private Player currentPlayer;
    private GameBoard gameBoard;
    private Prompt prompt;
    private Player player1;
    private Player player2;

    public Game(GameBoard board, Prompt prompt, Player player1, Player player2) {
        this.gameBoard = board;
        this.prompt = prompt;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void start(){
        Result result;
        do {
            result = this.gameLoop();
        } while(result.getStatus().equals(Result.Status.SUCCESS) || result.getStatus().equals(Result.Status.ERROR));
    }

    public Result gameLoop() {
        prompt.print(currentPlayer);
        String userInput = prompt.getInput();
        while(!InputValidator.validate(userInput)){
            prompt.print(currentPlayer);
            userInput = prompt.getInput();
        }
        UserMove currentMove = MoveParser.parse(userInput, currentPlayer.getToken());
        Result result = gameBoard.addMoveToBoard(currentMove);
        prompt.print(result);
        if (result.getStatus().equals(Result.Status.SUCCESS)) { swapPlayer();}
        return result;
    }

    private void swapPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
}
