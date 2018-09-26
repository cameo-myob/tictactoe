package com.company.tictactoe.prompt;

import com.company.tictactoe.Player;
import com.company.tictactoe.Result;

public interface Prompt {
    void print(Result output);
    void print(Player currentPlayer);
    void print(String output);
    String getInput();
}
