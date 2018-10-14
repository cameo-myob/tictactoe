package com.company.backend;

import com.company.backend.handler.HttpHandler;
import com.company.tictactoe.IOAdaptor;
import com.company.tictactoe.Player;
import com.company.tictactoe.Result;
import com.company.tictactoe.UserMove;
import com.sun.net.httpserver.HttpServer;
import org.json.JSONObject;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerAdaptor implements IOAdaptor {
    private HttpHandler handler = new HttpHandler();

    public ServerAdaptor() throws IOException {
        createServer();
    }

    private void createServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/addmove", handler);
        server.createContext("/addplayer", handler);
        server.start();
    }

    public Player getPlayerInfo() throws InterruptedException, IOException {
        JSONObject req = handler.getCurrentRequest();
        Player player = new Player(req.getString("name"), req.getString("token"));
        JSONObject res = new JSONObject();
        res.put("name", player.getName());
        res.put("token", player.getToken());
        handler.sendResponse(res);
        return player;
    }

    public void outputResult(Result output) throws IOException {
        JSONObject response = buildJSONResponse(output);
        handler.sendResponse(response);
    }

    public UserMove getValidMove(Player player) throws InterruptedException {
        JSONObject req = handler.getCurrentRequest();
        UserMove move = new UserMove(req.getInt("x"), req.getInt("y"));
        return move;
    }

    private JSONObject buildJSONResponse (Result result){
        JSONObject response = new JSONObject();
        response.put("board", result.getBoard().getBoard());
        response.put("status", result.getStatus().toString());
        response.put("message", result.getStatus().getMessage());
        return response;
    }
}
