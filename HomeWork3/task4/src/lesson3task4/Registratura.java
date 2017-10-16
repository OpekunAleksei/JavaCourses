/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3task4;

/**
 *
 * @author Алексей
 */
public class Registratura {
    private Patient patients[];
    private Doctor doctors[];
    private int kolvopatients=0;
    private int kolvodoctors=0;
    public Registratura() {
        patients = new Patient[10];
         doctors = new Doctor[10];
    }

   public void createpatients(String namesurname){
   patients[kolvopatients] = new Patient();
   patients[kolvopatients].setNameSurname(namesurname);
   kolvopatients=kolvopatients+1;
   }
     public void createdoctors(String namesurname){
   doctors[kolvodoctors] = new Doctor();
   doctors[kolvodoctors].setNameSurname(namesurname);
   kolvodoctors=kolvodoctors+1;
   }
     public void zapic(String namesurname){
         for (int i = 0 ; i < kolvodoctors;i++){
             boolean equals = doctors[i].getNameSurname().equals(namesurname);
             if (equals==true){
       doctors[i].setzapic();
             }      
         }     
     }
        public void otpis(String namesurname){
         for (int i = 0 ; i < kolvodoctors;i++){
             boolean equals = doctors[i].getNameSurname().equals(namesurname);
             if (equals==true){
       doctors[i].setotpis();
             }      
         }     
     }
     public int NPacientZapicKDoctor(String namesurname){
         int ID = 0;
    for (int i = 0 ; i < kolvodoctors;i++){
             boolean equals = doctors[i].getNameSurname().equals(namesurname);
             if (equals==true){
        ID=i;
             }      
         } 
return doctors[ID].getKolichestvoPatientov();
   }    
public int kolichestvoDoctors(){
 
  return  kolvodoctors;  
}
public int kolichestvoPatients(){
 
  return  kolvopatients;  
}
}
