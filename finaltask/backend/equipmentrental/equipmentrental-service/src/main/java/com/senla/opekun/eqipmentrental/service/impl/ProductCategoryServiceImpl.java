package com.senla.opekun.eqipmentrental.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.opekun.eqipmentrental.api.dao.IProductCategoryDao;
import com.senla.opekun.eqipmentrental.api.service.IProductCategoryService;
import com.senla.opekun.eqipmentrental.model.ProductCategory;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
@Transactional(isolation=Isolation.SERIALIZABLE)
public class ProductCategoryServiceImpl implements IProductCategoryService {

    @Autowired
    private IProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> getProductCategories() {
        return this.productCategoryDao.getAll();
    }

    @Override
    public void deleteProductCategory(Long id) {
        this.productCategoryDao.delete(id);
    }

    @Override
    public ProductCategory creteProductCategory(ProductCategory productCategory) {
        return this.productCategoryDao.save(productCategory);
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        return this.productCategoryDao.update(productCategory);
    }

}
