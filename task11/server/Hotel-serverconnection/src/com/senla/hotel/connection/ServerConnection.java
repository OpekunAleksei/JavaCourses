/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import org.apache.log4j.Logger;

public class ServerConnection {

    public static ServerConnection connection;
    private final Socket socket;
    private final ObjectOutputStream outputStream;
    private final ObjectInputStream inputStream;
    private static Logger logger = Logger.getLogger(ServerConnection.class);

    private ServerConnection() throws IOException {

<<<<<<< HEAD
        this.socket = new Socket("Алексей-ПК", 8071);
=======
        this.socket = new Socket("user-ПК", 8071);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
        this.inputStream = new ObjectInputStream(socket.getInputStream());
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    public static ServerConnection getInstance() {
        if (connection == null) {
            try {
                connection = new ServerConnection();
            } catch (IOException ex) {
                logger.error(new Date() + " " + ex.getMessage());
            }
        }
        return connection;
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    public void closeConnection() {
        try {
            this.socket.close();
            this.inputStream.close();
            this.outputStream.close();
        } catch (IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }
}
