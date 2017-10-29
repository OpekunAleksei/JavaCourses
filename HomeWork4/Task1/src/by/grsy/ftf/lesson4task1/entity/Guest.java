/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.entity;

import com.danco.training.TextFileWorker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Guest extends Entity {

    private TextFileWorker textFileWorker;
    private String name;
    private String surname;
    private Date arrivalDate;
    private Date dateOfDeparture;
    private Integer id;
    private static Integer counter = 0;
    private static String listOfGuestFromTextFile[] = new String[10];
    private Integer nuberOfRoom;

    public void setNuberOfRoom(Integer nuberOfRoom) {
        this.nuberOfRoom = nuberOfRoom;
    }

    public Integer getNuberOfRoom() {
        return nuberOfRoom;
    }

    public Guest(String line) throws ParseException {
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        // this.textFileWorker = new TextFileWorker("D:\\guestFile.txt");
        if (line != null) {
            Guest.listOfGuestFromTextFile = line.split(";");
            this.arrivalDate = dateformat3.parse(listOfGuestFromTextFile[0]);
            this.dateOfDeparture = dateformat3.parse(listOfGuestFromTextFile[1]);
            this.id = Integer.parseInt(listOfGuestFromTextFile[2]);
            this.name = listOfGuestFromTextFile[3];
            this.surname = listOfGuestFromTextFile[4];
        }
        //StringBuilder builder = new StringBuilder();
        // if ((arrivalDate != null) && (dateOfDeparture != null) && (id != null) && (name != null) && (surname != null)) {
        //  builder.append(arrivalDate);
        //  builder.append(";");
        //  builder.append(dateOfDeparture);
        //  builder.append(";");
        //  builder.append(id);
        //  builder.append(";");
        //  builder.append(name);
        //  builder.append(";");
        //  builder.append(surname);
        //  builder.append(";");
        //  Guest.listOfGuestFromTextFile[Guest.counter] = new String();
        //   Guest.listOfGuestFromTextFile[Guest.counter] = builder.toString();
        //  System.out.println(Guest.listOfGuestFromTextFile[0]);
        //  this.textFileWorker.writeToFile(Guest.listOfGuestFromTextFile);
        //  Guest.counter++;
        //   }
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surname;
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

    public void setSurName(String surName) {
        this.surname = surName;
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
