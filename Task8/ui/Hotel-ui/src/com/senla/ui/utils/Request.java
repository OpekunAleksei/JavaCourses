/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.utils;




import com.senla.hotel.connection.ServerConnection;
import com.senla.hotel.utils.Logger;
import java.io.IOException;

public class Request {
    private final Logger logger;
    public static Request request;
    private ServerConnection serverConnection;

    private Request() {
        this.logger = new Logger();
    }
    
    public static Request getInstance() {
        
        if (request == null) {
            request = new Request();
        }
        return request;
    }

    public void getServerConnection() {
         serverConnection= ServerConnection.getInstance();
    }
    public String pull(String data) {
        try {
            
            serverConnection.getOutputStream().writeObject(data);
            serverConnection.getOutputStream().flush();
            return (String) serverConnection.getInputStream().readObject();
        } catch (IOException | ClassNotFoundException ex) {
            logger.writeErrToFile("Problem with client", ex);
        }
        return null;
    } 
        public void closeConnection() {
       serverConnection.closeConnection();
    }
}
