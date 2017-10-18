/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3task3;

/**
 *
 * @author Алексей
 */
public class Lesson3Task3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Bucket bucket= new Bucket();
bucket.SetBucket("Rose", 2200);
bucket.SetBucket("Romashka", 2500);
bucket.SetBucket("Rose", 1700);
bucket.SetBucket("Romashka", 1100);
bucket.SetBucket("Rose", 5000);

    System.out.println("Cost of a bouquet: " + bucket.getSumm());

    }
    
}
