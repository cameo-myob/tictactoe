package com.company.backend.handler;

import com.company.backend.HttpResponse;
import com.company.backend.io.ReqPrinter;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class PostHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        ReqPrinter.printRequestInfo(exchange);
        String response = "{\"message\": \"post method\"}";
        exchange.getResponseHeaders().set("Content-Type:", "application/json;");
        exchange.sendResponseHeaders(HttpResponse.OK.getCode(), response.getBytes().length);

        OutputStream os = exchange.getResponseBody();

        for(char c : response.toCharArray()) {
            os.write(c);
        }

        os.close();
    }
}