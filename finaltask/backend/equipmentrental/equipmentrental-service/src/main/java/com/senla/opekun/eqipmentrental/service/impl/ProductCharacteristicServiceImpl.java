package com.senla.opekun.eqipmentrental.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senla.opekun.eqipmentrental.api.dao.IProductCharacteristicDao;
import com.senla.opekun.eqipmentrental.api.service.IProductCharactersticService;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.ProductCharacteristic;

@Service
@Transactional(isolation=Isolation.SERIALIZABLE)
public class ProductCharacteristicServiceImpl implements IProductCharactersticService {

    /**
     * @author Алексей Опекун
     * @version 1.0
     */
    @Autowired
    private IProductCharacteristicDao productCharacteristic;

    @Override
    public ProductCharacteristic addProductCharacteristicToProduct(ProductCharacteristic productCharacteristic, Product product) {
        productCharacteristic.setProduct(product);
        return this.productCharacteristic.save(productCharacteristic);
    }

    @Override
    public ProductCharacteristic updateProductCharacteristic(ProductCharacteristic productCharacteristic) {
        return this.productCharacteristic.update(productCharacteristic);
    }

    @Override
    public void deleteProductCharacteristic(Long id) {
        this.productCharacteristic.delete(id);
    }
}
