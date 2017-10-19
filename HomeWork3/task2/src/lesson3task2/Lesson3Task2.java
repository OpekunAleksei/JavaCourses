/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3task2;

/**
 *
 * @author Алексей
 */
public class Lesson3Task2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        randomNumber massiv = new randomNumber();
        System.out.println("Random number: " + massiv.GetRundomNumber());
        System.out.println("Max numeral: " + massiv.GetMaxNumeral());
    }

}
