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
public class Registratura {

    private Patient patients[];
    private Doctor doctors[];
    private int kolvopatients = 0;
    private int kolvodoctors = 0;

    public Registratura() {
        patients = new Patient[10];
        doctors = new Doctor[10];
    }

    public void createpatients(String namesurname, int ID) {
        patients[kolvopatients] = new Patient(ID);
        patients[kolvopatients].setNameSurname(namesurname);
        kolvopatients = kolvopatients + 1;
    }

    public void createdoctors(String namesurname) {
        doctors[kolvodoctors] = new Doctor();
        doctors[kolvodoctors].setNameSurname(namesurname);
        kolvodoctors = kolvodoctors + 1;
    }

    public void entry(String Doctorname, int id) {
        int numberpatient = 0;
        for (int i = 0; i < kolvopatients; i++) {
            boolean equals = patients[i].getID() == id;
            if (equals == true) {
                numberpatient = i;
            }
        }
        for (int i = 0; i < kolvodoctors; i++) {
            boolean equals = doctors[i].getNameSurname().equals(Doctorname);
            if (equals == true) {

                doctors[i].entrypatient(patients[numberpatient].getNameSurname(), patients[numberpatient].getID());

            }
        }
    }

    public void describe(String DoctorName, int id) {
        int numberpatient = 0;
        for (int i = 0; i < kolvopatients; i++) {
            boolean equals = patients[i].getID() == id;
            if (equals == true) {
                numberpatient = i;
            }
            for (i = 0; i < kolvodoctors; i++) {
                equals = doctors[i].getNameSurname().equals(DoctorName);
                if (equals == true) {
                    doctors[i].deletepatient(patients[numberpatient].getID());
                }
            }
        }
    }

    public int NPacientZapicKDoctor(String namesurname) {
        int ID = 0;
        for (int i = 0; i < kolvodoctors; i++) {
            boolean equals = doctors[i].getNameSurname().equals(namesurname);
            if (equals == true) {
                ID = i;
            }
        }
        return doctors[ID].getnumberPatientov();
    }

    public int numberDoctors() {

        return kolvodoctors;
    }

    public int numberPatients() {

        return kolvopatients;
    }
}
