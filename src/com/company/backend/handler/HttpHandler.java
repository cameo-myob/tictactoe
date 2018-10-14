package com.company.backend.handler;

import com.company.backend.HttpResponse;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class HttpHandler implements com.sun.net.httpserver.HttpHandler {
    private HttpExchange exchange;
    private JSONObject currentRequest;

    public void handle(HttpExchange exchange) throws IOException {
        this.exchange = exchange;
        InputStream request = exchange.getRequestBody();
        Scanner scan = new Scanner(request);
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();
        request.close();

        if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type,Authorization");
            exchange.sendResponseHeaders(HttpResponse.NO_CONTENT.getCode(), -1);

            return;
        } else {
            this.currentRequest = new JSONObject(str);
        }

    }

    public void sendResponse(JSONObject response) throws IOException{
        Headers headers = exchange.getResponseHeaders();
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Content-Type:", "application/json;");

        exchange.sendResponseHeaders(HttpResponse.OK.getCode(), response.toString().getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.toString().getBytes());
        os.close();
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