/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transfer {

    private String line = null;
    private Scanner scanner = null;
    private final List<String> list = new ArrayList();

    public List<String> importData(String path) throws FileNotFoundException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(
                path))) {
            while ((line = reader.readLine()) != null) {
                if (!"".equals(line)) {
                    scanner = new Scanner(line);
                    scanner.useDelimiter(";");
                    list.add(line);
                }
            }
        }
        return list;
    }

    public void exportGuestData(String path, String data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Name;" + "Id;" + "Arrival date;" + "Date of departure;" + "\n" + data);
        }
    }

    public void exportRoomData(String path, String data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Number;" + "Capacity;" + "Id;" + "Number of stars;" + "Price;" + "Status(repaired or serviced);" + "\n" + data);
        }
    }

    public void exportServiceData(String path, String data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Id;" + "Category;" + "Price;" + "\n" + data);
        }
    }
}
