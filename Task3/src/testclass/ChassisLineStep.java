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
public class ChassisLineStep implements ILineStep{
       @Override
    public IProductPart buildProductPart() {
             System.out.println("The Chassis is  Assembly");
 return new Chassis();
    } 
}
