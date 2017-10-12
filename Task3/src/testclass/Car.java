/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

/**
 *
 * @author Алексей
 */
public class Car implements IProduct{
Body body;
Chassis chassis;
Engine engine;
public Car(){
       System.out.println("Constructor car "); 
}
    @Override
    public void installFirstPart(IProductPart productPart) {
      this.body=(Body) productPart;
      System.out.println("Body is installeted");
    }

    @Override
    public void installSecondPart(IProductPart productPart) {
      this.chassis=(Chassis) productPart; 
      System.out.println("Chassis is installeted");
    }

    @Override
    public void installThirdPart(IProductPart productPart) {
      this.engine=(Engine) productPart;      
      System.out.println("Engine is installeted");
    }
    
}
