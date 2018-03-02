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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "service")
@CsvEntity(fileName = "Service.csv", valuesSeparator = ";")
public class Service extends AEntity {

    @Column(name = "price")
    @CsvProperty(colomnNumber = 2, propertyType = PropertyType.SimpleProperty)
    private Integer price;
    @Column(name = "category")
    @CsvProperty(colomnNumber = 1, propertyType = PropertyType.SimpleProperty)
    private String category;
    @Column(name = "idservice")
    @GeneratedValue(strategy = GenerationType.TABLE)
    @CsvProperty(colomnNumber = 0, propertyType = PropertyType.SimpleProperty)
    @Id
    private Integer id;
    @ManyToMany(mappedBy = "service",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<History> history = new HashSet<History>();

    public Set<History> getHistory() {
        return history;
    }

    public void setHistory(Set<History> history) {
        this.history = history;
    }

    public Service(Integer price, String category, Integer id) {
        this.price = price;
        this.category = category;
        this.id = id;
    }

    public Service() {
        this.price = null;
        this.category = null;
        this.id = null;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public String getCategory() {
        return category;
    }
}
