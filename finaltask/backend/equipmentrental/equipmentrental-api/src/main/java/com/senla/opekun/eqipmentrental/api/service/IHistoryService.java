package com.senla.opekun.eqipmentrental.api.service;

import com.senla.opekun.eqipmentrental.model.History;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.User;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IHistoryService {

    public History returnProduct(Product product);

    public BigDecimal getProductRentPrice(History history);

    public void rentProduct(History history);

    public List<History> getHistorysOfProduct(Product product);

    public Date getReturnDateOfProduct(Product product);

    public List<Product> getProductsOfUser(User user);
}
