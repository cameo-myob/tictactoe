package com.company.backend;

import com.company.backend.handler.AddMoveHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class JavaServer {
    public static void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
        server.createContext("/addmove", new AddMoveHandler());
        server.start();
    }
}
