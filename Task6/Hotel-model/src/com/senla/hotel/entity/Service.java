/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.entity;

public class Service extends Entity {

    private Integer price;
    private String category;
    private Integer id;

    public Service(Integer price, String category, Integer id) {
        this.price = price;
        this.category = category;
        this.id = id;
    }

    public Service(String line) {
        this.id = Integer.parseInt(line.split(";")[0]);
        this.category = line.split(";")[1];
        this.price = Integer.parseInt(line.split(";")[2]);
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public void setId(int id) {
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
