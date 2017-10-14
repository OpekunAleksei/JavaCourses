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
public class Massiv {
   private int n;
   private int a[];
   private int summ;
   
    Massiv(int n){
        this.n = n;
        this.a = new int[this.n];
        for(int i = 0 ; i < this.n ; i++){
            
            this.a[i]=new java.util.Random().nextInt(10);           
        }

}
   public String getSumm(){
       summ = 0;
      for(int i = 0 ; i < this.n ; i++){
            summ = summ + this.a[i];         
        }
String stroka;
        stroka = String.valueOf(summ);
return stroka;
   }
   
   public String getMassiv(){
       StringBuilder builder = new StringBuilder();
       for(int i = 0 ; i < this.n ; i++){
           builder.append(this.a[i]);
          builder.append(" ");
        }
        String stroka;
        stroka = builder.toString();
return stroka;
   }

 
}
