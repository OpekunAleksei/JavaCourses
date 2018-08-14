package com.senla.opekun.eqipmentrental.dao.impl;

import com.senla.opekun.eqipmentrental.api.dao.IProductCategoryDao;
import com.senla.opekun.eqipmentrental.model.ProductCategory;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class ProductCategoryDaoImpl extends AbstractDao<ProductCategory> implements IProductCategoryDao {

    public ProductCategoryDaoImpl() {
        super(ProductCategory.class);
    }
}
