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
public class randomNumber {
    private int rnumber;
    
     randomNumber(){
         do{
     this.rnumber = new java.util.Random().nextInt(999);
    }
         while (this.rnumber<=99);
}
     public int GetRundomNumber(){
         return this.rnumber;
     }
       public int GetMaxNumeral(){
           int massiv[];
           massiv =new int[3];
           int maxindex = 0;
             massiv[0]=this.rnumber%10;
             massiv[1]=this.rnumber/10%10;
             massiv[2]=this.rnumber/100%10;
             for(int i =0;i<2;i++)
             {
              if (massiv[maxindex] < massiv[i]) {
        maxindex = i;
    }
             }
         return massiv[maxindex];
     }
}
