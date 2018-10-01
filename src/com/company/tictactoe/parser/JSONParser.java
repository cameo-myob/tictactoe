package com.company.tictactoe.parser;

import com.company.tictactoe.Player;
import com.company.tictactoe.Result;
import com.company.tictactoe.UserMove;
import org.json.*;


public class JSONParser {
    public static UserMove toUserMove(JSONObject request){
        int x = request.getInt("x");
        int y = request.getInt("y");
        String token = request.getString("token");
        return new UserMove(x, y, token);
    }

    public static Player toPlayer(JSONObject request){
        String name = request.getString("name");
        String token = request.getString("token");
        return new Player(name, token);
    }

    public static JSONObject buildJSONResponse (Result result){
    JSONObject response = new JSONObject();
    response.put("board", result.getGameBoard());
    response.put("status", result.getStatus().toString());
    response.put("message", result.getStatusMessage());
    return response;
    }
}


// This should be done by the game
//        UserMove move = JSONParser.toUserMove(reqBody);
//        Player player = JSONParser.toPlayer(reqBody);
//        Result result = board.addMoveToBoard(move, player);
//        JSONObject response = buildJSONResponse(result);