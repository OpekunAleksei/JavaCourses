/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.server.servertheard;

import com.senla.hotel.server.utils.DataParser;
import com.senla.hotel.api.facade.IHotelAdministrator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
<<<<<<< HEAD:task11/server/Hotel-server/src/com/senla/hotel/server/servertheard/ServerThread.java
import java.util.Arrays;
=======
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a:task11/server/Hotel-server/src/com/senla/hotel/server/servertheard/ServerThread.java
import java.util.Date;
import org.apache.log4j.Logger;

public class ServerThread extends Thread {

    private final DataParser dataParser;
    private final ObjectOutputStream os;
    private final ObjectInputStream is;
    private static Logger logger = Logger.getLogger(ServerThread.class);

    public ServerThread(Socket s, IHotelAdministrator hotelAdministrator) throws IOException {
        dataParser = new DataParser(hotelAdministrator);
        os = new ObjectOutputStream(s.getOutputStream());
        is = new ObjectInputStream(s.getInputStream());

    }

    @Override
    public void run() {
        String str = null;
        try {
<<<<<<< HEAD:task11/server/Hotel-server/src/com/senla/hotel/server/servertheard/ServerThread.java
            while (!"-1".equals(str = (String) is.readObject())) {
                if (str != null) {
                    os.writeObject(dataParser.setInputData(str));
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            logger.error(new Date() + " " + Arrays.toString(e.getStackTrace()));
=======
            while ((str = (String) is.readObject()) != null) {
                os.writeObject(dataParser.setInputData(str));
            }
        } catch (IOException | ClassNotFoundException e) {
            logger.error(new Date() + " " + e.getMessage());
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a:task11/server/Hotel-server/src/com/senla/hotel/server/servertheard/ServerThread.java
        } finally {
            disconnect();
        }
    }

    public void disconnect() {
        try {
            os.close();
            is.close();
        } catch (IOException e) {
            logger.error(new Date() + " " + e.getMessage());
        } finally {
            this.interrupt();
        }
    }
}
