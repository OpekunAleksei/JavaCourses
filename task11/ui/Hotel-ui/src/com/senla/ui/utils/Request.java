/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.utils;

import com.senla.hotel.connection.ServerConnection;

import java.io.IOException;
import java.util.Date;
import org.apache.log4j.Logger;


public class Request {

    private static Logger logger =Logger.getLogger(Request.class);
    public static Request request;
    private ServerConnection serverConnection;

    private Request() {
       
    }

    public static Request getInstance() {

        if (request == null) {
            request = new Request();
        }
        return request;
    }

    public void getServerConnection() {
        serverConnection = ServerConnection.getInstance();
    }

    public String pull(String data) {
        try {

            serverConnection.getOutputStream().writeObject(data);
            serverConnection.getOutputStream().flush();
            return (String) serverConnection.getInputStream().readObject();
        } catch (IOException | ClassNotFoundException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    public void closeConnection() {
        serverConnection.closeConnection();
    }
}
