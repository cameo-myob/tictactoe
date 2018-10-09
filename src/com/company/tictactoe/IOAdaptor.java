package com.company.tictactoe;

import java.io.IOException;

public interface IOAdaptor {
    Player getPlayerInfo() throws InterruptedException, IOException;
    void outputResult(Result output) throws IOException;

    UserMove getValidMove(Player player) throws InterruptedException;
}
