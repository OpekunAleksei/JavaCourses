/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.server.runner;

import com.senla.hotel.server.server.Server;

public class Runner {

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
