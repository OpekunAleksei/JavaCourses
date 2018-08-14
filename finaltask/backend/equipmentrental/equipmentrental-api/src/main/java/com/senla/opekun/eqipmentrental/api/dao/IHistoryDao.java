package com.senla.opekun.eqipmentrental.api.dao;

import com.senla.opekun.eqipmentrental.model.History;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.User;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IHistoryDao extends IGenericDao<History> {

    public List<History> getHistorysOfProduct(Product product);

    public History getHistoryByProduct(Product product);

    public List<Product> getProductsOfUser(User user);
}
