public class Patient extends Man{
    private int RegistryNumber;
    private Adress adress;
    private Card card;
    private Medication medication;
    public Patient(Adress adress,Card card,Medication medication){ 
        this.adress = adress;
        this.card =card;
        this.medication = medication;
               System.out.println("Constructor patient ");
    }

public void RegistrationToDoctor(){
this.RegistryNumber=1;
}

public void CanselVisitToDOctor(){
 this.RegistryNumber=0;  
}
public void PayServices(){
    
}
    public int getRegistryNumber()
   {
     return RegistryNumber;
   }
 public void setRegistryNumber(int registryNumber)
   {
     this.RegistryNumber=registryNumber;
   }

    
}