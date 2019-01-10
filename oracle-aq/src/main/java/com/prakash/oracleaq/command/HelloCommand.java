package com.prakash.oracleaq.command;

public class HelloCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Hello");
    }
}
