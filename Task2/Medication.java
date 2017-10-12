public class Medication {
    private String Kind;
    private String Description;
     public Medication(String Kind, String Description){ 
           System.out.println("Constructor Medication ");
           this.Description = Description;
           this.Kind = Kind;          
    }    
  public String getKind()
   {
     return Kind;
   }
 public void setKind(String kind)
   {
     this.Kind=kind;
   }
   public String getDescription()
   {
     return Description;
   }
 public void setDescription(String description)
   {
     this.Description=description;
   }
}
