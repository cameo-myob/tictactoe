package com.company;

public interface Prompt {
    void print(Result output);
    void print(Player currentPlayer);
    void print(String output);
    String getInput();
}
