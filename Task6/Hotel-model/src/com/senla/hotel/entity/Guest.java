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
        dateConverter = new DateConverter();
        this.name = line.split(";")[0];
        this.id = Integer.parseInt(line.split(";")[1]);
        System.err.println(dateConverter.getDateFormat().toPattern());
        this.arrivalDate = (Date) dateConverter.getDateFormat().parse(line.split(";")[2]);
        System.err.println(line.split(";")[3]);
        this.dateOfDeparture = dateConverter.getDateFormat().parse(line.split(";")[3]);

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
