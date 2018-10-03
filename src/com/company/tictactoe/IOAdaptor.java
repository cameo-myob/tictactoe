package com.company.tictactoe;

public interface IOAdaptor {
    Player getPlayerInfo();
    void outputResult(Result output);
    void promptPlayerForMove(Player player);

    UserMove getValidMove(Player player);
}
