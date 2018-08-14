package com.senla.opekun.eqipmentrental.service.impl;

import com.senla.opekun.eqipmentrental.api.dao.IProductDao;
import com.senla.opekun.eqipmentrental.api.service.IProductService;
import com.senla.opekun.eqipmentrental.model.Manufacturer;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.ProductCategory;
import java.util.List;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class ProductServiceImpl implements IProductService {

    private final static String EXCEPTION_MSG = "This manufacturer name exist";
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> getProductsByCategory(ProductCategory productCategory) {
	return this.productDao.getProductsByCategory(productCategory);
    }

    @Override
    public Manufacturer getManufacturerOfProduct(Product product) {
	return this.productDao.getManufacturerOfProduct(product);
    }

    @Override
    public List<Product> getProducts() {
	return this.productDao.getAll();
    }

    @Override
    public void deleteProduct(Long id) {
	this.productDao.delete(id);
    }

    @Override
    public Product createProduct(Product product) {
	product.getProductCharacteristic().forEach((productCharacterstic) -> {
	    productCharacterstic.setProduct(product);
	});
	product.setEnable(Boolean.TRUE);
	return this.productDao.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
	return this.productDao.update(product);
    }

    @Override
    public void getProductByTitle(String title) throws DataIntegrityViolationException {
	if (this.productDao.getProductByTitle(title) != null) {
	    throw new DataIntegrityViolationException(EXCEPTION_MSG);
	}
    }

    @Override
    public Product testJoin() {
	return this.productDao.testJoin();
    }

    @Override
    public Product getProductWithCharacteristics(Long id) {
	return this.productDao.getProductWithCharacteristics(id);
    }

}
