package com.senla.opekun.eqipmentrental.api.service;

import com.senla.opekun.eqipmentrental.exceptions.LoginExist;
import com.senla.opekun.eqipmentrental.model.Manufacturer;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.ProductCategory;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IProductService {

    public List<Product> getProductsByCategory(ProductCategory productCategory);

    public Manufacturer getManufacturerOfProduct(Product product);

    public List<Product> getProducts();

    public Product getProductWithCharacteristics(Long id);

    public void deleteProduct(Long id);

    public Product createProduct(Product product);

    public Product testJoin();

    public Product updateProduct(Product product);

    public void getProductByTitle(String title) throws LoginExist;
}
