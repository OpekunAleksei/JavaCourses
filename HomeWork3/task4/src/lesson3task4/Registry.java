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

    public void createPatients(String namesurname, int ID) {
        patients[numberPatients] = new Patient(ID);
        patients[numberPatients].setNameSurname(namesurname);
        numberPatients = numberPatients + 1;
    }

    public void createDoctors(String namesurname) {
        doctors[numberDoctors] = new Doctor();
        doctors[numberDoctors].setNameSurname(namesurname);
        numberDoctors = numberDoctors + 1;
    }

    public void entry(String Doctorname, int id) {
        int numberpatient = 0;
        for (int i = 0; i < numberPatients; i++) {
            boolean equals = patients[i].getID() == id;
            if (equals == true) {
                numberpatient = i;
            }
        }
        for (int i = 0; i < numberDoctors; i++) {
            boolean equals = doctors[i].getNameSurname().equals(Doctorname);
            if (equals == true) {

                doctors[i].entryPatient(patients[numberpatient].getNameSurname(), patients[numberpatient].getID());

            }
        }
    }

    public void describe(String DoctorName, int id) {
        int numberpatient = 0;
        for (int i = 0; i < numberPatients; i++) {
            boolean equals = patients[i].getID() == id;
            if (equals == true) {
                numberpatient = i;
            }
            for (i = 0; i < numberDoctors; i++) {
                equals = doctors[i].getNameSurname().equals(DoctorName);
                if (equals == true) {
                    doctors[i].deletePatient(patients[numberpatient].getID());
                }
            }
        }
    }

    public int getNumberPatientsOnDoctor(String namesurname) {
        int ID = 0;
        for (int i = 0; i < numberDoctors; i++) {
            boolean equals = doctors[i].getNameSurname().equals(namesurname);
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
