/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import com.danco.training.TextFileWorker;

public class FileWorker {

    private TextFileWorker textFileWorker;

    public String[] readFromFile(String path) {
        textFileWorker = new TextFileWorker(path);
        String stringArray[];
        stringArray = textFileWorker.readFromFile();
        return stringArray;

    }
    public void writeToGuestFile(String path,String line[]){
        if (path==null){
            path="D:\\guestFile.txt";
        }
      textFileWorker=  new TextFileWorker(path);
      textFileWorker.writeToFile(line);
    }
        public void writeToRoomFile(String path,String line[]){
              if (path==null){
            path="D:\\RoomFile.txt";
        }
      textFileWorker=  new TextFileWorker(path);
      textFileWorker.writeToFile(line);
    }
            public void writeToServiceFile(String path,String line[]){
                  if (path==null){
            path="D:\\ServiceFile.txt";
        }
      textFileWorker=  new TextFileWorker(path);
      textFileWorker.writeToFile(line);
    }
}
