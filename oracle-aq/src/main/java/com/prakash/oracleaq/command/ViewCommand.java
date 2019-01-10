package com.prakash.oracleaq.command;

import com.prakash.oracleaq.LocalOracleAQListenerUtil;
import oracle.AQ.AQException;
import oracle.AQ.AQQueue;
import oracle.AQ.AQSession;

public class ViewCommand implements Command {
    public static void viewAQQueue(final AQSession aqSession) throws AQException {
        final AQQueue queue = aqSession.getQueue("aqjava", "q_docret_1_queue");
        System.out.println("Queue Name : " + queue.getName());
        System.out.println("Queue Owner : " + queue.getOwner());
        System.out.println("Queue Table Name : " + queue.getQueueTableName());
    }

    @Override
    public void execute() throws AQException {
        System.out.println("create aq session: View" );
        AQSession aqSession = null;
        aqSession = LocalOracleAQListenerUtil.createAQSession();
        viewAQQueue(aqSession);
    }
}
