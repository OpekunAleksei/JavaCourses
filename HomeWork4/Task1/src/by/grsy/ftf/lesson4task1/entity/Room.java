/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.entity;

import by.grsy.ftf.lesson4task1.enumList.RoomStatus;
import com.danco.training.TextFileWorker;
import java.util.Date;

public class Room extends Entity {

    private Integer number;
    private Integer price;
    private Integer capacity;
    private Integer numberOfStars;
    private Boolean busy;
    private RoomStatus status;
    private Date arrivalDate;
    private Date dateOfDeparture;
    private Integer id;
    private TextFileWorker textFileWorker;
    private static Integer counter = 0;
    private static String listOfGRoomFromTextFile[] = new String[10];

    public Room(String line) {

        // this.textFileWorker = new TextFileWorker("D:\\roomFile.txt");
        if (line != null) {
            Room.listOfGRoomFromTextFile = line.split(";");
            this.number = Integer.parseInt(listOfGRoomFromTextFile[0]);
            this.capacity = Integer.parseInt(listOfGRoomFromTextFile[1]);
            this.id = Integer.parseInt(listOfGRoomFromTextFile[2]);
            this.numberOfStars = Integer.parseInt(listOfGRoomFromTextFile[3]);
            this.price = Integer.parseInt(listOfGRoomFromTextFile[4]);
            if ("repaired".equals(listOfGRoomFromTextFile[5])) {
                this.status = RoomStatus.repaired;
            } else {
                this.status = RoomStatus.serviced;
            }
        }
        //StringBuilder builder = new StringBuilder();
        // if ((number != null) && (id != null) && (capacity != null) && (numberOfStars != null) && (price != null) && (status != null)) {
        //  builder.append(number);
        //  builder.append(";");
        //  builder.append(capacity);
        // builder.append(";");
        //  builder.append(id);
        //  builder.append(";");
        // builder.append(numberOfStars);
        // builder.append(";");
        // builder.append(price);
        // builder.append(";");
        // builder.append(status);
        // builder.append(";");
        // Room.listOfGRoomFromTextFile[Room.counter] = new String();
        //Room.listOfGRoomFromTextFile[Room.counter] = builder.toString();
        //System.out.println(Room.listOfGRoomFromTextFile[0]);
        //this.textFileWorker.writeToFile(Room.listOfGRoomFromTextFile);
        //Room.counter++;
        //  }
    }

    public Integer getNumber() {
        return number;
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

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setNumberOfStars(Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
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
