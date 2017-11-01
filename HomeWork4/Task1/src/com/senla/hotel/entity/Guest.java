/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.entity;

import com.danco.training.TextFileWorker;
import com.senla.hotel.utils.FileWorker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Guest extends Entity {

    private TextFileWorker textFileWorker;
    private String name;

    private Date arrivalDate;
    private Date dateOfDeparture;
    private Integer id;
    private static Integer counter = 0;
    private FileWorker fileWorker;
    private String listOfGuestFromTextFile[] = new String[10];

    public Guest(String path) throws ParseException {
        if (path == null) {
            path = "D:\\guestFile.txt";
        }
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        this.fileWorker = new FileWorker();
        if (fileWorker.readFromFile(path)[counter] != null) {
            this.listOfGuestFromTextFile = fileWorker.readFromFile(path)[counter].split(";");
            this.arrivalDate = dateformat3.parse(this.listOfGuestFromTextFile[0]);
            this.dateOfDeparture = dateformat3.parse(this.listOfGuestFromTextFile[1]);
            this.id = Integer.parseInt(this.listOfGuestFromTextFile[2]);
            this.name = this.listOfGuestFromTextFile[3];
            counter++;
        }

    }

    public String getName() {
        return name;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}
