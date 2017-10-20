/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3task4;

public class Registry {

    private Patient patients[];
    private Doctor doctors[];
    private int numberPatients = 0;
    private int numberDoctors = 0;

    public Registry() {
        patients = new Patient[10];
        doctors = new Doctor[10];
    }

    public void createPatients(String nameSurname, int ID) {
        patients[numberPatients] = new Patient(ID, nameSurname);
        numberPatients = numberPatients + 1;
    }

    public void createDoctors(String nameSurname) {
        doctors[numberDoctors] = new Doctor(nameSurname);
        numberDoctors = numberDoctors + 1;
    }

    public void entry(String Doctorname, int id) {
        int numberPatient = 0;
        for (int i = 0; i < numberPatients; i++) {
            boolean equals = patients[i].getID() == id;
            if (equals == true) {
                numberPatient = i;
            }
        }
        for (int i = 0; i < numberDoctors; i++) {
            boolean equals = doctors[i].getNameSurname().equals(Doctorname);
            if (equals == true) {

                doctors[i].entryPatient(patients[numberPatient].getNameSurname(), patients[numberPatient].getID());

            }
        }
    }

    public void describe(String doctorName, int id) {
        int numberPatient = 0;
        for (int i = 0; i < numberPatients; i++) {
            boolean equals = patients[i].getID() == id;
            if (equals == true) {
                numberPatient = i;
            }
            for (i = 0; i < numberDoctors; i++) {
                equals = doctors[i].getNameSurname().equals(doctorName);
                if (equals == true) {
                    doctors[i].deletePatient(patients[numberPatient].getID());
                }
            }
        }
    }

    public int getNumberPatientsOnDoctor(String nameSurname) {
        int ID = 0;
        for (int i = 0; i < numberDoctors; i++) {
            boolean equals = doctors[i].getNameSurname().equals(nameSurname);
            if (equals == true) {
                ID = i;
            }
        }
        return doctors[ID].getNumberPatientov();
    }

    public int numberDoctors() {

        return numberDoctors;
    }

    public int numberPatients() {

        return numberPatients;
    }
}
