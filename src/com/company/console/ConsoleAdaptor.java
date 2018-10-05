package com.company.console;

import com.company.console.prompt.ConsolePrompt;
import com.company.console.prompt.StringBoardFormatter;
import com.company.tictactoe.IOAdaptor;
import com.company.tictactoe.Player;
import com.company.tictactoe.Result;
import com.company.tictactoe.UserMove;

public class ConsoleAdaptor implements IOAdaptor {
    private StringBoardFormatter boardFormatter = new StringBoardFormatter();
    private ConsolePrompt prompt = new ConsolePrompt();

    public void outputResult(Result result) {
        prompt.print(result.getStatus().getMessage());
        prompt.print(boardFormatter.format(result.getBoard().getBoard()));
    }

    public void promptPlayerForMove(Player player){
        String playerName = player.getName();
        String playerToken = player.getToken();

        prompt.print(playerName + ", enter a coordinate x,y to place your " + playerToken + " or enter 'q' to quit: ");
    }

    public Player getPlayerInfo(){
        prompt.print("Please enter Player name:");
        String playerName = prompt.getInput();
        prompt.print("Please enter Player token:");
        String playerToken = prompt.getInput();
        return new Player(playerName, playerToken);
    }

    public UserMove getValidMove(Player currentPlayer){
        promptPlayerForMove(currentPlayer);
        String userInput = prompt.getInput();
        while(!InputValidator.validate(userInput)){
            promptPlayerForMove(currentPlayer);
            userInput = prompt.getInput();
        }
        return MoveParser.parse(userInput);
    }


}