package com.company;

public class WinningCombination {
    public final UserMove firstPosition;
    public final UserMove secondPosition;
    public final UserMove thirdPosition;

    public WinningCombination(UserMove firstPosition, UserMove secondPosition, UserMove thirdPosition){
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
    }
}
