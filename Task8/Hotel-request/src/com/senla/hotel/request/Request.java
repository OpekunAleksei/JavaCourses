/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.request;

import com.senla.hotel.utils.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Request {

    public static Request connection;
    private final Socket socket;
    private final PrintStream ps;
    private final BufferedReader br;
    private static final Logger logger = new Logger();

    private Request() throws IOException {

        this.socket = new Socket("user-ПК", 8071);
        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.ps = new PrintStream(socket.getOutputStream());
    }

    public static Request getInstance() {
        if (connection == null) {
            try {
                connection = new Request();
            } catch (IOException ex) {
                logger.writeErrToFile("Problem with client", ex);
            }
        }
        return connection;
    }

    public String pull(String data) {
        ps.println(data);
        try {
            return br.readLine();
        } catch (IOException ex) {
            logger.writeErrToFile("Problem with client", ex);
        }
        return null;
    }

    public void closeConnection() {
        try {
            this.socket.close();
            this.br.close();
            this.ps.close();
        } catch (IOException ex) {
            logger.writeErrToFile("Problem with client", ex);
        }
    }
}
