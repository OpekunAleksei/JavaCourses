/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.logging.Level;

public class Logger {

    public void writeErrToFile(String exception, Exception e) {
        System.err.println(exception);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\err.txt"))) {
            bw.write(exception);
            bw.newLine();
            bw.write(e.toString());
            bw.newLine();
            for (StackTraceElement stackTrace : e.getStackTrace()) {
                bw.write(stackTrace.toString());
                bw.newLine();
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
