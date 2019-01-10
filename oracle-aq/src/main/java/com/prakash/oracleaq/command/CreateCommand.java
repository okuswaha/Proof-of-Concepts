package com.prakash.oracleaq.command;

import com.prakash.oracleaq.LocalOracleAQListenerUtil;
import oracle.AQ.*;

public class CreateCommand implements Command {
    @Override
    public void execute() throws AQException {
        System.out.println("create aq session: start" );
        AQSession aqSession = null;
        aqSession = LocalOracleAQListenerUtil.createAQSession();
        createAQQueueTableAndAQQueue(aqSession);
    }

    public static void createAQQueueTableAndAQQueue(final AQSession aqSession) throws AQException {
        AQQueueTableProperty aqQueueTableProperty;
        AQQueueTable aqQueueTable;
        AQQueueProperty aqQueueProperty;
        AQQueue aqQueue;

        aqQueueTableProperty = new AQQueueTableProperty("RAW");
        aqQueueTable = aqSession.createQueueTable("aqjava", "q_docret_1_tab", aqQueueTableProperty);
        System.out.println("q_docret_1_tab AQQueueTable Created");

        aqQueueProperty = new AQQueueProperty();
        // q_docret_1_queue
        aqQueue = aqSession.createQueue(aqQueueTable, "q_docret_1_queue", aqQueueProperty);
        System.out.println("q_docret_1_queue AQQueue Created");

        System.out.println("Get Queue Name" + aqQueue.getName());
    }
}
