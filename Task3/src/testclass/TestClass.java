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
public class TestClass {

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
           
         
		AsemblyLine assemblyLine = new AsemblyLine(new BodyLineStep(),new ChassisLineStep(),new EngineLineStep());
      assemblyLine.assembleProduct(new Car());
	}
}
