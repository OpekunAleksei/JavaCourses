/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.entity;

import com.senla.hotel.annotation.enums.PropertyType;
import com.senla.hotel.annotations.CsvEntity;
import com.senla.hotel.annotations.CsvProperty;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room")
@CsvEntity(fileName = "Room.csv", valuesSeparator = ";")
public class Room extends AEntity implements Cloneable {

    @Column(name = "number")
    @CsvProperty(colomnNumber = 0, propertyType = PropertyType.SimpleProperty)
    private Integer number;
    @Column(name = "price")
    @CsvProperty(colomnNumber = 4, propertyType = PropertyType.SimpleProperty)
    private Integer price;
    @Column(name = "capacity")
    @CsvProperty(colomnNumber = 1, propertyType = PropertyType.SimpleProperty)
    private Integer capacity;
    @Column(name = "numberOfStars")
    @CsvProperty(colomnNumber = 3, propertyType = PropertyType.SimpleProperty)
    private Integer numberOfStars;
    @Column(name = "busy")
    private Boolean busy;
    @Column(name = "status")
    @CsvProperty(colomnNumber = 5, propertyType = PropertyType.SimpleProperty)
    private String status;
    @Column(name = "idroom")
    @CsvProperty(colomnNumber = 2, propertyType = PropertyType.SimpleProperty)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<History> history = new HashSet<History>();

    public Room(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, String status, Boolean busy) {
        this.busy = busy;
        this.number = number;
        this.capacity = capacity;
        this.id = id;
        this.numberOfStars = numberOfStars;
        this.price = price;
        this.status = status;
    }

    public void setHistory(Set<History> history) {
        this.history = history;
    }

    public Set<History> getHistory() {
        return history;
    }

    public Room() {

    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        Room room = (Room) super.clone();
        room.setId(null);
        room.setNumber(null);
        room.setHistory(null);
        return room;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Boolean getBusy() {
        return busy;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
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
