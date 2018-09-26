package com.company.backend.handler;

import com.company.backend.HttpResponse;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AddMoveHandler implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        JSONObject reqBody = extractReqBody(exchange);
        String response = "hello";
        exchange.getResponseHeaders().set("Content-Type:",
                "application/json;");
        exchange.sendResponseHeaders(HttpResponse.OK.getCode(), response.toString().getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.toString().getBytes("UTF-8"));
        os.close();
    }

    // does this belong to the game?
    private JSONObject extractReqBody(HttpExchange exchange) throws IOException {
        InputStream request = exchange.getRequestBody();
        JSONTokener reqBody = new JSONTokener(request);
        JSONObject parsedBody = new JSONObject(reqBody);
        request.close();
        return parsedBody;
    }
}