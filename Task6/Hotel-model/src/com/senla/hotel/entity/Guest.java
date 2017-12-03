/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.entity;

import com.senla.hotel.util.DateConverter;
import java.text.ParseException;
import java.util.Date;

public class Guest extends Entity {

    private transient DateConverter dateConverter;
    private String name;
    private Date arrivalDate;
    private Date dateOfDeparture;
    private Integer id;

    public Guest(String name, Date arrivalDate, Date dateOfDeparture, Integer id) {
        this.arrivalDate = arrivalDate;
        this.dateOfDeparture = dateOfDeparture;
        this.id = id;
        this.name = name;
    }

    public Guest(String line) throws ParseException {
        String[] arr = line.split(";");
        dateConverter = new DateConverter();
        this.name = arr[0];
        this.id = Integer.parseInt(arr[1]);
        this.arrivalDate = dateConverter.parseDate(arr[2]);
        this.dateOfDeparture = dateConverter.parseDate(arr[3]);

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
    public void setId(Integer id) {
        this.id = id;
    }

}
