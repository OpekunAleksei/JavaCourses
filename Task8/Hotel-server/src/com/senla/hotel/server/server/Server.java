/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.server.server;

import com.senla.hotel.server.servertheard.ServerThread;
import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.facade.HotelAdministrator;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private final static IHotelAdministrator hotelAdministrator = HotelAdministrator.getInstance();

    public void start() {

        try {
            ServerSocket serv = new ServerSocket(8071);
            while (true) {

                Socket sock = serv.accept();
                ServerThread server = new ServerThread(sock, hotelAdministrator);
                server.start();
            }
        } catch (IOException e) {

        }
    }
}
