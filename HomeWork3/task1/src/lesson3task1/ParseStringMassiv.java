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
public class ParseStringMassiv {
   private int ammounrt;
   private int massiv[];
   private int summ;
   
    ParseStringMassiv(int n){
        this.ammounrt = n;
        this.massiv = new int[this.ammounrt];

}
   public void getMassiv(){
    for(int i = 0 ; i < this.ammounrt ; i++){
            
            this.massiv[i]=new java.util.Random().nextInt(10);           
        }   
   }
   public String getSumm(){
       summ = 0;
      for(int i = 0 ; i < this.ammounrt ; i++){
            summ = summ + this.massiv[i];         
        }
String stroka;
        stroka = String.valueOf(summ);
return stroka;
   }
   
   public String StringMassiv(){
       StringBuilder builder = new StringBuilder();
       for(int i = 0 ; i < this.ammounrt ; i++){
           builder.append(this.massiv[i]);
          builder.append(" ");
        }
        String stroka;
        stroka = builder.toString();
return stroka;
   }

 
}
