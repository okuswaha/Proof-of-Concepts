package com.prakash.oracleaq.command;

import oracle.AQ.AQException;

public class UnknownCommand implements Command {
    @Override
    public void execute() throws AQException {
        System.out.println("Unknown Command");
    }
}
