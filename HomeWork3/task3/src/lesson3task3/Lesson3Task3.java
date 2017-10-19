/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3task3;

public class Lesson3Task3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bucket bucket = new Bucket();
        Rose rose = new Rose(20);
        Romashka romashka = new Romashka(50);
        Vasilki vasilki = new Vasilki(150);
        bucket.assemble(rose);
        bucket.assemble(vasilki);
        bucket.assemble(romashka);
        System.out.println("Cost of a bouquet: " + bucket.getAmount());

    }

}
