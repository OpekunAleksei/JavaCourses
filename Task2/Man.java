public class Man {
       public Man(){ 
               System.out.println("Constructor man ");
    }
    private String Name;
    private String Surname;
    private String Sex;
   
    public String getName()
   {
     return Name;
   }
 public void setName(String name)
   {
     this.Name=name;
   }
     public String getSurname()
   {
     return Surname;
   }
 public void setSurname(String surname)
   {
     this.Surname=surname;
   }
      public String getSex()
   {
     return Sex;
   }
 public void setSex(String sex)
   {
     this.Sex=sex;
   }
}