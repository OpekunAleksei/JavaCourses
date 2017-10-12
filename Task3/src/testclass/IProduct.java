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
public interface IProduct {
        public void installFirstPart(IProductPart productPart);
	public void installSecondPart(IProductPart productPart);
	public void installThirdPart(IProductPart productPart);
}
