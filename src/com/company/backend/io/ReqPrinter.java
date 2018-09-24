package com.company.backend.io;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Scanner;

public class ReqPrinter {
    public static void printRequestInfo(HttpExchange exchange) throws IOException {
        System.out.println("-- headers --");
        Headers requestHeaders = exchange.getRequestHeaders();
        requestHeaders.entrySet().forEach(System.out::println);

        System.out.println("-- HTTP method --");
        String requestMethod = exchange.getRequestMethod();
        System.out.println(requestMethod);

        System.out.println("-- query --");
        URI requestURI = exchange.getRequestURI();
        String query = requestURI.getQuery();
        System.out.println(query);

        System.out.println("--- req body ---");
        InputStream reqBody = exchange.getRequestBody();
        Scanner s = new Scanner(reqBody).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        System.out.println(result);
        reqBody.close();
    }
}
