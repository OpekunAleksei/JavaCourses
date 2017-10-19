/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3task4;

public class Doctor extends Human {

    private int numberPatients;
    private Patient patient[];

    Doctor() {
        patient = new Patient[10];
        this.numberPatients = 0;
    }

    public void entryPatient(String name, int id) {
        this.patient[this.numberPatients] = new Patient(id);
        this.patient[this.numberPatients].setNameSurname(name);
        this.numberPatients = this.numberPatients + 1;
    }

    public void deletePatient(int id) {
        int numberPatient = 0;
        for (int i = 0; i < this.numberPatients; i++) {
            boolean equals = this.patient[i].getID() == id;
            if (equals == true) {
                numberPatient = i;
            }
            for (i = numberPatient; i < this.numberPatients - 1; i++) {
                this.patient[i].setID(this.patient[i + 1].getID());
                this.patient[i].setNameSurname(this.patient[i + 1].getNameSurname());
            }
        }
        this.numberPatients = this.numberPatients - 1;
    }

    public int getNumberPatientov() {
        return numberPatients;
    }
}
