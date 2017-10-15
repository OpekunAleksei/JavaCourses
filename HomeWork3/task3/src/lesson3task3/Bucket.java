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
public class Bucket {

   private Flower bucket[];
   Bucket(){
    this.bucket = new Flower[5];
    this.bucket[0] =  new Romashka();
    this.bucket[1] =  new Rose();
    this.bucket[2] =  new Vasilki();
    this.bucket[3] =  new Rose();
    this.bucket[4] =  new Vasilki();
   System.out.println("The bouquet is collected");
   }
   public int getSumm(){
       int summa = 0;
for(int i = 0 ; i < 4; i++){
     summa = bucket[i].getPrice() + summa;
}
return summa;
}
 
}
