/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.utils;

import com.senla.hotel.utils.Logger;
import com.senla.hotel.utils.Printer;
import java.util.Scanner;

public class TextWorker {

    private final Scanner scanner = new Scanner(System.in);
    private final Logger logger = new Logger();
    private final Printer printer = new Printer();
    private Integer newNumberOfRoom = null;

    public void setNewNumberOfRoom(Integer newNumberOfRoom) {
        this.newNumberOfRoom = newNumberOfRoom;
    }

    public Integer getNewNumberOfRoom() {
        return newNumberOfRoom;
    }

    public String getStringInput() {
        try {
            return scanner.next();
        } catch (Exception e) {
            logger.writeErrToFile("Wrong input data", e);
            return null;
        }
    }

    public void setLog(String line, Exception e) {
        logger.writeErrToFile(line, e);
    }

    public void println(String line) {
        printer.println(line);
    }

    public void print(String line) {
        printer.print(line);
    }

    public Integer getIntegerInput() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            logger.writeErrToFile("Wrong input data", e);
            return null;
        }
    }

}
