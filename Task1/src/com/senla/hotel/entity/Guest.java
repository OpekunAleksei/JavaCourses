/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Guest extends Entity {

    private String name;
    private Date arrivalDate;
    private Date dateOfDeparture;
    private Integer id;

    public Guest(String line) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.arrivalDate = dateFormat.parse(line.split(";")[0]);
        this.dateOfDeparture = dateFormat.parse(line.split(";")[1]);
        this.id = Integer.parseInt(line.split(";")[2]);
        this.name = line.split(";")[3];
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
