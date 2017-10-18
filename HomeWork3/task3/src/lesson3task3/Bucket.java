package lesson3task3;

/**
 *
 * @author Алексей
 */
public class Bucket {
private int counter=0;
private int amount=5;
   private Flower bucket[];
   Bucket(){
    this.bucket = new Flower[amount];
   }
   public void SetBucket(String name,int price){
if (counter<amount) {
    switch (name) {
        case "Rose":
            bucket[counter]=new Rose(price);
            counter++;
            break;
        case "Romashka":
            bucket[counter]=new Romashka(price);
            counter++;
            break;
        case "Vasilki":
            bucket[counter]=new Vasilki(price);
            counter++;
            break;
        default:
            break;
    }
}
else {
      System.out.println("Out of range");  
}

   }

   public int getSumm(){
       int summa = 0;
for(int i = 0 ; i < amount; i++){
     summa = bucket[i].getPrice()+ summa;
}
return summa;
}
 
}