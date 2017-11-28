/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import com.senla.hotel.entity.Guest;
import com.senla.hotel.entity.History;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serialization {

    private final Logger logger = new Logger();

    public void serializeGuest(String path, List<Guest> guest) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(guest);
            objectOutputStream.flush();
        } catch (IOException ex) {
            logger.writeErrToFile("Dont find file", ex);
        }

    }

    public void serializeRoom(String path, List<Room> room) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(room);
            objectOutputStream.flush();
        } catch (IOException ex) {
            logger.writeErrToFile("Dont find file", ex);
        }

    }

    public void serializeService(String path, List<Service> service) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(service);
                objectOutputStream.flush();
            }
        } catch (IOException ex) {
            logger.writeErrToFile("Dont find file", ex);
        }

    }

    public void serializeHistory(String path, List<History> history) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(history);
                objectOutputStream.flush();
            }
        } catch (IOException ex) {
            logger.writeErrToFile("Dont find file", ex);
        }

    }

    public Object deSerialize(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream oin = new ObjectInputStream(fis);
            return oin.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            logger.writeErrToFile("Dont find file", ex);
            return null;
        }
    }
}
