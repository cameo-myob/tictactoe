package com.company.backend.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class TestHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        if(method.equals("GET")){
            GetHandler handler = new GetHandler();
            handler.handle(exchange);
        } else if (method.equals("POST")){
            PostHandler handler = new PostHandler();
            handler.handle(exchange);
        }
    }
}
