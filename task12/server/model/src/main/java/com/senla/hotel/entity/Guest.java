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
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "guest")
@CsvEntity(fileName = "Guest.csv", valuesSeparator = ";")
public class Guest extends AEntity {

    @Column(name = "name")
    @CsvProperty(colomnNumber = 0, propertyType = PropertyType.SimpleProperty)
    private String name;
    @Column(name = "arrivaldate")
    @CsvProperty(colomnNumber = 2, propertyType = PropertyType.SimpleProperty)
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date arrivalDate;
    @Column(name = "departureDate")
    @CsvProperty(colomnNumber = 3, propertyType = PropertyType.SimpleProperty)
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date departureDate;
    @CsvProperty(colomnNumber = 1, propertyType = PropertyType.SimpleProperty)
    @Column(name = "idGuest")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @OneToMany(mappedBy = "guest")
    private Set<History> history = new HashSet<History>();

    public Guest(String name, Date arrivalDate, Date dateOfDeparture, Integer id) {
        this.arrivalDate = arrivalDate;
        this.departureDate = dateOfDeparture;
        this.id = id;
        this.name = name;
    }

    public void setHistory(Set<History> history) {
        this.history = history;
    }

    public Set<History> getHistory() {
        return history;
    }

    public Guest() {
    }

    public String getName() {
        return name;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date dateOfDeparture) {
        this.departureDate = dateOfDeparture;
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
