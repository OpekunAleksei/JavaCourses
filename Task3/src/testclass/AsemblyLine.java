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
public class AsemblyLine implements IAssemblyLine {
    	BodyLineStep body;
	ChassisLineStep chassis;
	EngineLineStep engine;

     public AsemblyLine(BodyLineStep body, ChassisLineStep chassis, EngineLineStep engine) {
		this.body = body;
		this.chassis = chassis;
		this.engine = engine;
		System.out.println("Constructor Assembly ");
	}   
            @Override
    public IProduct assembleProduct(IProduct product) {
		product.installFirstPart(body.buildProductPart());
		product.installSecondPart(chassis.buildProductPart());
		product.installThirdPart(engine.buildProductPart());
		return product;
	}
}
