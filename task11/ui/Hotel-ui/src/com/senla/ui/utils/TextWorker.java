/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.utils;


import com.senla.hotel.utils.Printer;
import java.util.Date;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class TextWorker {

    private final Scanner scanner = new Scanner(System.in);
    private static Logger logger =  Logger.getLogger(TextWorker.class);
    private final Printer printer = new Printer();
    private Integer newNumberOfRoom = null;
    public static TextWorker textWorker ;

 
  

   public static TextWorker getInstance() {
        if (textWorker == null) {
            textWorker = new TextWorker();
        }
        return textWorker;
    }

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
                   logger.error(new Date() + " " + e.getMessage());
            return null;
        }
    }

    public void setLog(String line, Exception e) {
               logger.error(new Date() + " " + e.getMessage());
    }

    public void println(String line) {
        printer.println(line);
    }

    public void print(String line) {
        printer.print(line);
    }

    public String createData(String... args) {
        String data = "";
        for (String arg : args) {
            data = data + arg + ";";
        }
        return data;

    }

    public String createLine(String nameFunction, String data) {
        return nameFunction + "/" + data;
    }

    public Integer getIntegerInput() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
                   logger.error(new Date() + " " + e.getMessage());
            return null;
        }
    }

}
