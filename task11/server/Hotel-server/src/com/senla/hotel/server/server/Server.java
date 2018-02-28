/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.server.server;

import com.senla.hotel.server.servertheard.ServerThread;
import com.senla.hotel.facade.HotelAdministrator;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import org.apache.log4j.Logger;

public class Server {
<<<<<<< HEAD:task11/server/Hotel-server/src/com/senla/hotel/server/server/Server.java
=======

    private final static IHotelAdministrator hotelAdministrator = HotelAdministrator.getInstance();
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a:task11/server/Hotel-server/src/com/senla/hotel/server/server/Server.java
    private static Logger logger = Logger.getLogger(Server.class);

    public void start() {

        try {
            ServerSocket serv = new ServerSocket(8071);
            while (true) {
                Socket sock = serv.accept();
                ServerThread server = new ServerThread(sock, HotelAdministrator.getInstance());
                server.start();
            }
        } catch (IOException e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }
}
