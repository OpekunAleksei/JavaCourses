/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import com.danco.training.TextFileWorker;
import java.util.ArrayList;
import java.util.Arrays;

public class Logger {

    private ArrayList err;
    private TextFileWorker textFileWorker;

    public Logger() {
        textFileWorker = new TextFileWorker("D:\\err.txt");
        this.err = new ArrayList<>();
    }

    public void writeErrToFile(Exception e) {
        err.add(e.toString());
        for (StackTraceElement stackTrace : e.getStackTrace()) {
            err.add(stackTrace.toString());
        }
        String[] stringArray;
        stringArray = Arrays.copyOf(err.toArray(), err.size(), String[].class);
        textFileWorker.writeToFile(stringArray);
    }
}
