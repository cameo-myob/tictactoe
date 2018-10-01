package com.company.backend.parser;

import com.company.tictactoe.Result;
import com.company.tictactoe.UserMove;
import com.company.tictactoe.board.TicTacToeBoard;
import org.json.*;

import java.util.ArrayList;

public class JSONParser {
    public UserMove toUserMove(JSONObject request){
        int x = request.getInt("x");
        int y = request.getInt("y");
        String token = request.getString("token");
        return new UserMove(x, y, token);
    }

    public TicTacToeBoard toBoard(JSONObject request){
        JSONArray JSONBoard = request.getJSONArray("board");
        String[][] stringBoard = JSONtoStringArray(JSONBoard);
        return new TicTacToeBoard(stringBoard);
    }

    private String[][] JSONtoStringArray(JSONArray jsonBoard) {
        String[][] stringArray = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

        for (int i = 0; i < jsonBoard.length(); i++){
            JSONArray row = jsonBoard.getJSONArray(i);
            for(int j = 0; j < row.length(); j++){
                stringArray[i][j] = row.getString(j);
            }
        }

        return stringArray;
    }

    public JSONObject buildJSONResponse (Result result){
    JSONObject response = new JSONObject();
    response.put("board", result.getGameBoard());
    response.put("status", result.getStatus().toString());
    response.put("message", result.getStatusMessage());
    System.out.println("===== RESPONSE =====");
    System.out.println(response);

        return response;
    }
}


