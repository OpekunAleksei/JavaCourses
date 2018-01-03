/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serialization {

    private final Logger logger = new Logger();
    private volatile  String path;

    public Serialization() {
        this.path = null;
    }

    public synchronized void  serializeEntity(String path, List entity) {
        this.path = path;   
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.path);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(entity);
                objectOutputStream.flush();
            } catch (IOException ex) {
                logger.writeErrToFile("Dont find file", ex);
            }
        
    }

    public synchronized Object deSerialize(String path) {
        this.path = path;
        try (FileInputStream fis = new FileInputStream(this.path);
                ObjectInputStream oin = new ObjectInputStream(fis)) {
            return oin.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            logger.writeErrToFile("Dont find file", ex);
            return null;
        }
    }
}
