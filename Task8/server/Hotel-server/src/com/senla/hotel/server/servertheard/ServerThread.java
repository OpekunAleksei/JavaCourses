/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.server.servertheard;

import com.senla.hotel.server.utils.DataParser;
import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.utils.Logger;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {

    private final DataParser dataParser;
    private final ObjectOutputStream os;
    private final ObjectInputStream is;
    private final Logger logger;

    public ServerThread(Socket s, IHotelAdministrator hotelAdministrator) throws IOException {
        dataParser = new DataParser(hotelAdministrator);
        os = new ObjectOutputStream(s.getOutputStream());
        is = new ObjectInputStream(s.getInputStream());
        logger = new Logger();
    }

    @Override
    public void run() {
        String str = null;
        try {
            while ((str = (String) is.readObject()) != null) {
                os.writeObject(dataParser.setInputData(str));
            }
        } catch (IOException | ClassNotFoundException e) {
            logger.writeErrToFile("Problem with server", e);
        } finally {
            disconnect();
        }
    }

    public void disconnect() {
        try {
            os.close();
            is.close();
        } catch (IOException e) {
            logger.writeErrToFile("Problem with server", e);
        } finally {
            this.interrupt();
        }
    }
}
