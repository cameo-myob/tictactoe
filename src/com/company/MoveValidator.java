package com.company;

public class MoveValidator {
    public static boolean validate(String input){
        try{
            String[] move = input.split(",");
            int x = Integer.parseInt(move[0]) - 1;
            int y = Integer.parseInt(move[1]) - 1;
            return true;
        } catch (ArrayIndexOutOfBoundsException error){
            return false;
        } catch (NumberFormatException error){
            return false;
        }
    }
}
