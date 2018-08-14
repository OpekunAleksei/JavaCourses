package com.senla.opekun.eqipmentrental.api.service;

import com.senla.opekun.eqipmentrental.model.ProductCategory;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IProductCategoryService {

    public void deleteProductCategory(Long id);

    public ProductCategory creteProductCategory(ProductCategory productCategory);

    public ProductCategory updateProductCategory(ProductCategory productCategory);

    public List<ProductCategory> getProductCategories();

}
