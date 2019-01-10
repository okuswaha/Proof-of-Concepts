package com.prakash.oracleaq.command;

public class CommandFactory {
    public static Command getCommand(String commandName) {
        if (commandName.equalsIgnoreCase("hello")) {
            return new HelloCommand();
        } else if (commandName.equalsIgnoreCase("create")) {
            return new CreateCommand();
        } else if (commandName.equalsIgnoreCase("view")) {
            return new ViewCommand();
        } else if (commandName.equalsIgnoreCase("enqueue")) {
            return new EnQueueCommand();
        } else if (commandName.equalsIgnoreCase("dequeue")) {
            return new DequeueCommand();
        } else {
            return new UnknownCommand();
        }
    }
}
