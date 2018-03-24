/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import com.senla.hotel.entity.Client;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Scanner;

public class Transfer {

    private String auditPath;

    public Transfer() {
    }

    public Transfer(String path) {
        auditPath = path;
    }

    private String line = null;

    private final List<String> list = new ArrayList();

    public List<String> importData(String path) throws FileNotFoundException, IOException {
        list.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(
                path))) {
            while ((line = reader.readLine()) != null) {
                if (!"".equals(line)) {
                    Scanner scanner = new Scanner(line);
                    scanner.useDelimiter(";");
                    list.add(line);
                }
            }
        }
        return list;
    }

    public void auditUserAction(Client user, String data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.auditPath, true))) {
            bw.write(new Date() + " " + data + " " + user.getLogin() + "\n");
        }
    }

    public void export(String path, String data, String simpleName, String firstLine) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            if (null != simpleName) {
                switch (simpleName) {
                    case "Room":
                        bw.write(firstLine + "\n" + data);
                        break;
                    case "Guest":
                        bw.write(firstLine + "\n" + data);
                        break;
                    case "Service":
                        bw.write(firstLine + "\n" + data);
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
