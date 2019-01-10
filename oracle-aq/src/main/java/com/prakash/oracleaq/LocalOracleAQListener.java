package com.prakash.oracleaq;

import com.prakash.oracleaq.command.Command;
import com.prakash.oracleaq.command.CommandFactory;
import oracle.AQ.AQException;

public class LocalOracleAQListener {
    public static void main(String[] args) throws AQException {
        final Command command = CommandFactory.getCommand(args[0]);
        command.execute();
    }
}
