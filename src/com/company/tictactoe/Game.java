package com.company.tictactoe;

import com.company.console.Prompt;
import com.company.tictactoe.board.GameBoard;

public class Game {
    private Player currentPlayer;
    private GameBoard gameBoard;
    private Prompt prompt;
    private Player player1;
    private Player player2;

    public Game(GameBoard board, Prompt prompt) {
        this.gameBoard = board;
        this.prompt = prompt;
    }

    public void startGame(){
        Player player1 = getPlayerInfo();
        Player player2 = getPlayerInfo();
        this.currentPlayer = player1;
        Result result;
        do {
            result = gameLoop();
            prompt.print(result);
        } while(result.getStatus().equals(Result.Status.SUCCESS) || result.getStatus().equals(Result.Status.ERROR));
    }

    private Result gameLoop() {
        prompt.print(currentPlayer);
        UserMove currentMove = getValidMove();
        Result result = gameBoard.addMoveToBoard(currentMove, currentPlayer);
        if (result.getStatus().equals(Result.Status.SUCCESS)) { swapPlayer();}
        return result;
    }

    private UserMove getValidMove(){
        String userInput = prompt.getInput();
        while(!InputValidator.validate(userInput)){
            prompt.print(currentPlayer);
            userInput = prompt.getInput();
        }
        return MoveParser.parse(userInput);
    }

    private void swapPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    private Player getPlayerInfo(){
        prompt.print("Please enter Player name:");
        String playerName = prompt.getInput();
        prompt.print("Please enter Player token:");
        String playerToken = prompt.getInput();
        return new Player(playerName, playerToken);
    }
}
