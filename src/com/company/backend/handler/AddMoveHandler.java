package com.company.backend.handler;

import com.company.backend.HttpResponse;
import com.company.backend.parser.JSONParser;
import com.company.tictactoe.Result;
import com.company.tictactoe.UserMove;
import com.company.tictactoe.board.TicTacToeBoard;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class AddMoveHandler implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        JSONParser parser = new JSONParser();
        JSONObject reqBody = extractReqBody(exchange);
        UserMove move = parser.toUserMove(reqBody);
        TicTacToeBoard board = parser.toBoard(reqBody);
        Result result = board.addMoveToBoard(move);
        JSONObject response = parser.buildJSONResponse(result);

        exchange.getResponseHeaders().set("Content-Type:",
                "application/json;");
        exchange.sendResponseHeaders(HttpResponse.OK.getCode(), response.toString().getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.toString().getBytes("UTF-8"));
        os.close();
    }

    private JSONObject extractReqBody(HttpExchange exchange) throws IOException {
        InputStream request = exchange.getRequestBody();
        JSONTokener reqBody = new JSONTokener(request);
        JSONObject parsedBody = new JSONObject(reqBody);
        request.close();
        System.out.println("===== REQUEST =====");
        System.out.println(parsedBody);
        return parsedBody;
    }
}