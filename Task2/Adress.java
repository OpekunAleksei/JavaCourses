public class Adress {
    private String City;
    private int Apartament;
    private int House;
    private String Street;
        public Adress(String City,int Apartament,int House,String Street){ 
           System.out.println("Constructor Adress ");
           this.City=City;
           this.Apartament=Apartament;
           this.House=House;
           this.Street=Street;
        } 
      public void ChangeCity(String newcity){
            this.City=newcity;
}
       public void Apartament(int newapartament){
            this.Apartament=newapartament;
}
       public void House(int newhouse){
            this.House=newhouse;
}
       public void Street(String newstreet){
            this.Street=newstreet;
}        
}
