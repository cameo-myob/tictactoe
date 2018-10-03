package com.company.console.prompt;

import java.util.Scanner;

public class ConsolePrompt {

    private Scanner input = new Scanner(System.in);

    public void print(String output){
        System.out.println(output);
    }

    public String getInput(){
        return input.nextLine();
    }
}
