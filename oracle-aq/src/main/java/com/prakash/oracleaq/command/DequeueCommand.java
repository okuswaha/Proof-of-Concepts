package com.prakash.oracleaq.command;

import com.prakash.oracleaq.LocalOracleAQListenerUtil;
import oracle.AQ.*;

import java.sql.Connection;
import java.sql.SQLException;

public class DequeueCommand implements Command {

    private void deQueue(final AQSession aqSession) throws AQException {
        Connection connection = ((AQOracleSession) aqSession).getDBConnection();
        AQQueue aqQueue = aqSession.getQueue("aqjava", "q_docret_1_queue");

        AQDequeueOption aqDequeueOption = new AQDequeueOption();
        aqDequeueOption.setDequeueMode(AQDequeueOption.DEQUEUE_REMOVE);
        aqDequeueOption.setWaitTime(10);

        AQMessage aqMessage = aqQueue.dequeue(aqDequeueOption);
        final AQRawPayload rawPayload = aqMessage.getRawPayload();
        byte[] data = rawPayload.getBytes();
        String message = new String(data);
        System.out.println("Data dequeued : "+ message);
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() throws AQException {
        System.out.println("create aq session: Dequeue" );
        AQSession aqSession = null;
        aqSession = LocalOracleAQListenerUtil.createAQSession();
        deQueue(aqSession);
    }
}
