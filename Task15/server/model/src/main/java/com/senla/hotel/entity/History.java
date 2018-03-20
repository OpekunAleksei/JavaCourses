package com.senla.hotel.entity;

import com.senla.hotel.annotation.enums.PropertyType;
import com.senla.hotel.annotations.CsvProperty;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History extends AEntity {

    @Column(name = "idhistory")
    @CsvProperty(colomnNumber = 2, propertyType = PropertyType.SimpleProperty)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest")
    private Guest guest;

    @Column(name = "enable")
    private Boolean enable;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "services", joinColumns = {
        @JoinColumn(name = "idhistory")
    }, inverseJoinColumns = {
        @JoinColumn(name = "idservice")})
    private List<Service> service = new ArrayList<Service>();

    public History() {
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public History(Integer id, Room room, Guest guest, Boolean enable, List<Service> services) {
        this.id = id;
        this.room = room;
        this.guest = guest;
        this.enable = enable;
        this.service = services;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
