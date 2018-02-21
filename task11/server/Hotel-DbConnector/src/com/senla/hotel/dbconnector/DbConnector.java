/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.dbconnector;

import com.senla.hotel.configuration.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class DbConnector {

    private final Configuration configuration = new Configuration();
    private static Logger logger = Logger.getLogger(DbConnector.class);
    private Connection connection;
    private static DbConnector dbConnector;

    public static DbConnector getIstance() {
        if (dbConnector == null) {
            dbConnector = new DbConnector();
        }
        return dbConnector;
    }

    public DbConnector() {
        connect();
    }

    private void connect() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(configuration.getURL(), configuration.getName(), configuration.getPassword());
        } catch (SQLException ex) {
            logger.error(new java.util.Date() + " " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;
    }
    
}
