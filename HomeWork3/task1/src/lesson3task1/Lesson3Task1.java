/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3task1;

/**
 *
 * @author Алексей
 */
public class Lesson3Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ParseStringMassiv massiv = new ParseStringMassiv(10);
        massiv.getMassiv();
        System.out.println("Массив чисел: " + massiv.StringMassiv());
        System.out.println("Сумма чисел: " + massiv.getSumm());
    }
}
