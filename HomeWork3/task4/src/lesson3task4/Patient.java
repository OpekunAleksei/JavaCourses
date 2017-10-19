/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3task4;

/**
 *
 * @author Алексей
 */
public class Patient extends Human {

    private int ID;

    Patient(int ID) {
        this.ID = ID;

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

}
