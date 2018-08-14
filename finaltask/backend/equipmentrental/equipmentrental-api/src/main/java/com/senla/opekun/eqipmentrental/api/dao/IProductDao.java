package com.senla.opekun.eqipmentrental.api.dao;

import com.senla.opekun.eqipmentrental.model.Manufacturer;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.ProductCategory;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IProductDao extends IGenericDao<Product> {

    public List<Product> getProductsByCategory(ProductCategory productCategory);

    public Manufacturer getManufacturerOfProduct(Product product);

    public Product getProductByTitle(String title);

    public Product testJoin();

    public Product getProductWithCharacteristics(Long id);
}
