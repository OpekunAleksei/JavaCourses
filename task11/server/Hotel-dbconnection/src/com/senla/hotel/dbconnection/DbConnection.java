/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.dbconnection;

import com.senla.hotel.configuration.Configuration;
import java.sql.*;
import org.apache.log4j.Logger;



public class DbConnection {

    public static DbConnection dbConnection;
    private static Logger logger = Logger.getLogger(DbConnection.class);
    private String url;
    private String name ;
    private  String password;
    private final Configuration configuration = new Configuration();
    private DbConnection() {

    }

    public static DbConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DbConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() {
        try {
            Class.forName(configuration.getDriverName());
             url = configuration.getURL();
             name = configuration.getName();
             password = configuration.getpassword();
            Connection connection = DriverManager.getConnection(url, name, password);
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
  logger.error(new java.util.Date() + " " + ex.getMessage());
        }
        return null;
    }
}
