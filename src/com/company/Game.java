package com.company;

public class Game {
    private Player currentPlayer;
    private GameBoard gameBoard;
    private Prompt prompt;
    private Player player1;
    private Player player2;
    private WinChecker winChecker = new WinChecker();
    private boolean gameRunning = true;

    public Game(GameBoard board, Prompt prompt, Player player1, Player player2) {
        this.gameBoard = board;
        this.prompt = prompt;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void run() {
        printBoardAndMessage("Welcome to Tic Tac Toe!");
        currentPlayer = player1;

        while (gameRunning) {
            prompt.print(promptUserForMove(currentPlayer.getName(), currentPlayer.getToken()));
            String currentMove = prompt.getInput();
            processUserInput(currentMove);
        }
    }
    
    private void processUserInput(String userInput) {
        if (isQuitInput(userInput)) {
            return;
        } else if (MoveValidator.validate(userInput)) {
            if(gameBoard.addMoveToBoard(MoveParser.parse(userInput), currentPlayer.getToken())) {
                processValidMove();
            } else prompt.print("Error: position out of bounds or already taken, please try again");
        } else prompt.print("Error: move must be in format x,y");
    }

    private void processValidMove() {

        if (gameBoard.isFull()) {
            printBoardAndMessage("Oh no, it's a draw!");
            gameRunning = false;
            return;
        } else if (winChecker.isWinningMove(gameBoard, currentPlayer.getToken())) {
            printBoardAndMessage("Congratulations, " + currentPlayer.getName() + " is the winner!");
            gameRunning = false;
            return;
        } else
        printBoardAndMessage("Move confirmed, here is the current board:");
        swapPlayer();
    }
    
    private boolean isQuitInput(String userInput) {
        if (userInput.isEmpty()) 
        {
            return false;
        }
        
        return userInput.equalsIgnoreCase("q") || userInput.equalsIgnoreCase("quit");
    }

    private void swapPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else currentPlayer = player1;
    }

    private void printBoardAndMessage(String message){
        prompt.print(message);
        prompt.print(gameBoard.printBoard());
    }

    private String promptUserForMove(String playerName, String playerToken) {
        if(playerName.isEmpty() || playerToken.isEmpty()){
            return "Player Name and/or Player Token cannot be empty";
        }
        return playerName + ", enter a coordinate x,y to place your " + playerToken + " or enter 'q' to quit: ";
    }
}
