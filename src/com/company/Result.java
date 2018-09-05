package com.company;

public class Result {

    public final String message;
    public final String board;
    public final String status;

    public Result(String board, String status, String message){
        this.board = board;
        this.status = status;
        this.message = message;
    }
}
