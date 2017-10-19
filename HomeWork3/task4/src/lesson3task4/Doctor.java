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
public class Doctor extends Human {

    private int kolichestvoPatientov;
    private Patient patient[];

    Doctor() {
        patient = new Patient[10];
        this.kolichestvoPatientov = 0;
    }

    public void entrypatient(String name, int id) {
        this.patient[this.kolichestvoPatientov] = new Patient(id);
        this.patient[this.kolichestvoPatientov].setNameSurname(name);
        this.kolichestvoPatientov = this.kolichestvoPatientov + 1;
    }

    public void deletepatient(int id) {
        int numberpatient = 0;
        for (int i = 0; i < this.kolichestvoPatientov; i++) {
            boolean equals = this.patient[i].getID() == id;
            if (equals == true) {
                numberpatient = i;
            }
            for (i = numberpatient; i < this.kolichestvoPatientov - 1; i++) {

                this.patient[i].setID(this.patient[i + 1].getID());
                this.patient[i].setNameSurname(this.patient[i + 1].getNameSurname());
            }

        }
        this.kolichestvoPatientov = this.kolichestvoPatientov - 1;
    }

    public int getnumberPatientov() {
        return kolichestvoPatientov;
    }
}
