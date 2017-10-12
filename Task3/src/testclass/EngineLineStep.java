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
public class EngineLineStep implements ILineStep{
        @Override
    public IProductPart buildProductPart() {
             System.out.println("The Engine is  Assembly");
 return new Engine();
    }    
}
