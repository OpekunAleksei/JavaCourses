/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.server.servertheard;

import com.senla.hotel.server.utils.DataParser;
import com.senla.hotel.api.facade.IHotelAdministrator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {

    private final DataParser dataParser;
    private final PrintStream os;
    private final BufferedReader is;

    public ServerThread(Socket s, IHotelAdministrator hotelAdministrator) throws IOException {
        dataParser = new DataParser(hotelAdministrator);
        os = new PrintStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));

    }

    @Override
    public void run() {
        String str;
        try {
            while ((str = is.readLine()) != null) {
                os.println(dataParser.setInputData(str));

            }
        } catch (IOException e) {

        } finally {
            disconnect();
        }
    }

    public void disconnect() {
        try {
            os.close();
            is.close();
        } catch (IOException e) {
        } finally {
            this.interrupt();
        }
    }
}
