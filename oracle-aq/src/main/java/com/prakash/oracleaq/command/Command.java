package com.prakash.oracleaq.command;

import oracle.AQ.AQException;

public interface Command {
    public void execute() throws AQException;
}
