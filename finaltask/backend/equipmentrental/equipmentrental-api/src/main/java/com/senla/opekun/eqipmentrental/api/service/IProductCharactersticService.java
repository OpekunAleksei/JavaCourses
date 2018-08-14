package com.senla.opekun.eqipmentrental.api.service;

import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.ProductCharacteristic;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IProductCharactersticService {

    public ProductCharacteristic addProductCharacteristicToProduct(ProductCharacteristic productCharacteristic, Product product);

    public ProductCharacteristic updateProductCharacteristic(ProductCharacteristic productCharacteristic);

    public void deleteProductCharacteristic(Long id);

}
