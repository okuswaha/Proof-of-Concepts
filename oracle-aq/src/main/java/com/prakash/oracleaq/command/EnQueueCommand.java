package com.prakash.oracleaq.command;

import com.prakash.oracleaq.LocalOracleAQListenerUtil;
import oracle.AQ.*;

import java.sql.Connection;
import java.sql.SQLException;

public class EnQueueCommand implements Command{

    private void enQueue(final AQSession aqSession) throws AQException {
        Connection connection = ((AQOracleSession) aqSession).getDBConnection();
        AQQueue aqQueue = aqSession.getQueue("aqjava","q_docret_1_queue");
        aqQueue.start();
        AQMessage aqMessage = aqQueue.createMessage();
        String data = "Hello My Friend";
        byte[] message = data.getBytes();
        AQRawPayload aqRawPayload = aqMessage.getRawPayload();
        aqRawPayload.setStream(message, message.length);

        AQEnqueueOption aqEnqueueOption = new AQEnqueueOption();
        aqQueue.enqueue(aqEnqueueOption, aqMessage);
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() throws AQException {
        System.out.println("create aq session: Enqueue" );
        AQSession aqSession = null;
        aqSession = LocalOracleAQListenerUtil.createAQSession();
        enQueue(aqSession);
    }
}
