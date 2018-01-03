/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.entity;

import com.senla.hotel.annotation.enums.PropertyType;
import com.senla.hotel.annotations.CsvEntity;
import com.senla.hotel.annotations.CsvProperty;

import java.util.Date;

@CsvEntity(fileName = "Guest.csv", valuesSeparator = ";")
public class Guest extends Entity {

    @CsvProperty(colomnNumber = 0, propertyType = PropertyType.SimpleProperty)
    private String name;
    @CsvProperty(colomnNumber = 2, propertyType = PropertyType.SimpleProperty)
    private Date arrivalDate;
    @CsvProperty(colomnNumber = 3, propertyType = PropertyType.SimpleProperty)
    private Date dateOfDeparture;
    @CsvProperty(colomnNumber = 1, propertyType = PropertyType.SimpleProperty)
    private Integer id;

    public Guest(String name, Date arrivalDate, Date dateOfDeparture, Integer id) {
        this.arrivalDate = arrivalDate;
        this.dateOfDeparture = dateOfDeparture;
        this.id = id;
        this.name = name;
    }

    public Guest() {
        this.arrivalDate = null;
        this.dateOfDeparture = null;
        this.id = null;
        this.name = null;
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
