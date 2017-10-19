/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3task4;

public class Lesson3Task4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Registry reg = new Registry();
        reg.createPatients("Petr Norman", 12);
        reg.createPatients("Alex Bak", 13);
        reg.createPatients("Hanna Lion", 15);
        reg.createPatients("Lia Long", 17);
        reg.createDoctors("Harry Potter");
        reg.createDoctors("Tom Ridl");
        reg.createDoctors("Albus Dambldor");
        reg.createDoctors("Severus Shark");
        reg.entry("Tom Ridl", 15);
        reg.entry("Tom Ridl", 17);
        System.out.println("The number of patients recorded by Tom Ridl " + reg.getNumberPatientsOnDoctor("Tom Ridl"));
        reg.describe("Tom Ridl", 20);
        System.out.println("The number of patients recorded by Tom Ridl " + reg.getNumberPatientsOnDoctor("Tom Ridl"));
        System.out.println("Number of doctors" + reg.numberDoctors());
        System.out.println("Number of patients" + reg.numberPatients());

    }

}
