package com.prakash.oracleaq;

import oracle.AQ.AQDriverManager;
import oracle.AQ.AQException;
import oracle.AQ.AQQueue;
import oracle.AQ.AQQueueProperty;
import oracle.AQ.AQQueueTable;
import oracle.AQ.AQQueueTableProperty;
import oracle.AQ.AQSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocalOracleAQListenerUtil {

    public static AQSession createAQSession() {
        Connection connection;
        AQSession aqSession = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "aqjava", "aqjava");
            System.out.println("JDBC connection Created");
            connection.setAutoCommit(false);

            Class.forName("oracle.AQ.AQOracleDriver");

            aqSession = AQDriverManager.createAQSession(connection);
            System.out.println("AQ Session Created");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (AQException e) {
            e.printStackTrace();
        }
        return aqSession;
    }

}