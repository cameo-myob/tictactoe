package com.company.backend.handler;

import com.company.backend.HttpResponse;
import com.sun.net.httpserver.HttpExchange;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HttpHandler implements com.sun.net.httpserver.HttpHandler {
    private HttpExchange exchange;
    private JSONObject currentRequest;

    public void handle(HttpExchange exchange) throws IOException {
        this.exchange = exchange;
        InputStream request = exchange.getRequestBody();
        JSONTokener reqBody = new JSONTokener(request);
        this.currentRequest = new JSONObject(reqBody);
        request.close();
        System.out.println(exchange.getRequestHeaders());
    }

    public void sendResponse(JSONObject response) throws IOException{
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "http://localhost:3000");

        if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type,Authorization");
            exchange.sendResponseHeaders(204, -1);
            return;
        } else {
            exchange.getResponseHeaders().set("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
            exchange.getResponseHeaders().set("Content-Type:",
                    "application/json;");
            exchange.sendResponseHeaders(HttpResponse.OK.getCode(), response.toString().getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        }
    }

    public JSONObject getCurrentRequest() throws InterruptedException {
        while(this.currentRequest == null){
            Thread.sleep(1000);
        }
        JSONObject req = this.currentRequest;
        this.currentRequest = null;
        return req;
    }
}