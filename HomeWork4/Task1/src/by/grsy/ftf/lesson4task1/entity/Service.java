/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.entity;

import com.danco.training.TextFileWorker;
import java.util.Date;

public class Service extends Entity {

    private Integer price;
    private String category;
    private Date dateOfUsing;
    private Integer id;
    private TextFileWorker textFileWorker;
    private static Integer counter = 0;
    private static String listOfServiceFromTextFile[] = new String[10];

    public Service(String line) {
        // this.textFileWorker = new TextFileWorker("D:\\serviceFile.txt");
        if (line != null) {
            Service.listOfServiceFromTextFile = line.split(";");
            this.id = Integer.parseInt(listOfServiceFromTextFile[0]);
            this.category = listOfServiceFromTextFile[1];
            this.price = Integer.parseInt(listOfServiceFromTextFile[2]);
        }

        // builder = new StringBuilder();
        // if ((id != null) && (category != null) && (price != null)) {
        //   builder.append(id);
        //  builder.append(";");
        //  builder.append(category);
        //  builder.append(";");
        //  builder.append(price);
        //  builder.append(";");
        //  Service.listOfServiceFromTextFile[Service.counter] = new String();
        //  Service.listOfServiceFromTextFile[Service.counter] = builder.toString();
        //   this.textFileWorker.writeToFile(Service.listOfServiceFromTextFile);
        //   Service.counter++;
        // }
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
