/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.entity;

import com.senla.hotel.annotation.enums.PropertyType;
import com.senla.hotel.annotations.CsvEntity;
import com.senla.hotel.annotations.CsvProperty;

@CsvEntity(fileName = "Service.csv", valuesSeparator = ";")
public class Service extends Entity {

    @CsvProperty(colomnNumber = 2, propertyType = PropertyType.SimpleProperty)
    private Integer price;
    @CsvProperty(colomnNumber = 1, propertyType = PropertyType.SimpleProperty)
    private String category;
    @CsvProperty(colomnNumber = 0, propertyType = PropertyType.SimpleProperty)
    private Integer id;

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
