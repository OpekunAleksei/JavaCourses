/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.entity;

import com.senla.hotel.entity.Entity;
import com.danco.training.TextFileWorker;
import com.senla.hotel.utils.FileWorker;
import java.util.Date;

public class Service extends Entity {

    private Integer price;
    private String category;
    private Date dateOfUsing;
    private Integer id;
    private static Integer counter = 0;
    private FileWorker fileWorker;
    private String listOfServiceFromTextFile[] = new String[10];

    public Service(String path) {
        this.fileWorker = new FileWorker();
        if (path == null) {
            path = "D:\\serviceFile.txt";
        }
        if (fileWorker.readFromFile(path)[counter] != null) {
            this.listOfServiceFromTextFile = fileWorker.readFromFile(path)[counter].split(";");
            this.id = Integer.parseInt(listOfServiceFromTextFile[0]);
            this.category = listOfServiceFromTextFile[1];
            this.price = Integer.parseInt(listOfServiceFromTextFile[2]);
        }
    }

    public Service() {
    }

    public Date getDateOfUsing() {
        return dateOfUsing;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setDateOfUsing(Date dateOfUsing) {
        this.dateOfUsing = dateOfUsing;
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
