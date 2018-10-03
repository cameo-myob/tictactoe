package com.company.console;

public class InputValidator {
    public static boolean validate(String input){
        if(input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")){
            System.exit(0);
        }

        if (input.contains(",")){
            String[] result = input.split(",");
            return result[0].matches("[0-9]") && result[1].matches("[0-9]");
        }
        return false;
    }
}
