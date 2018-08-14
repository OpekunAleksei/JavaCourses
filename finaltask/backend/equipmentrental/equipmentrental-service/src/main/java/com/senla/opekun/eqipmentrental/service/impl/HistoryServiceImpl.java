package com.senla.opekun.eqipmentrental.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.opekun.eqipmentrental.api.dao.IHistoryDao;
import com.senla.opekun.eqipmentrental.api.service.IHistoryService;
import com.senla.opekun.eqipmentrental.model.History;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.User;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
@Transactional(isolation=Isolation.SERIALIZABLE)
public class HistoryServiceImpl implements IHistoryService {

    @Autowired
    private IHistoryDao historyDao;

    @Override
    public History returnProduct(Product product) {
        History persistentHistory = this.historyDao.getHistoryByProduct(product);
        persistentHistory.setReturnDate(new Date());
        historyOperations(persistentHistory, Boolean.TRUE);
        return persistentHistory;
    }

    @Override
    public Date getReturnDateOfProduct(Product product) {
        return this.historyDao.getHistoryByProduct(product).getReturnDate();
    }

    @Override
    public List<Product> getProductsOfUser(User user) {
        return this.historyDao.getProductsOfUser(user);
    }

    @Override
    public BigDecimal getProductRentPrice(History history) {
        Long days = (history.getReturnDate().getTime() - history.getDateOfReceiving().getTime())
                / (24 * 60 * 60 * 1000);
        Long excessDays = (new Date().getTime() - history.getReturnDate().getTime()) / (24 * 60 * 60 * 1000);
        Long totalPrice = days * history.getProduct().getPrice().longValue()
                + excessDays * history.getProduct().getPrice().longValue();
        return new BigDecimal(totalPrice);
    }

    @Override
    public void rentProduct(History history) {
        History persistentHistory = this.historyDao.save(history);
        historyOperations(persistentHistory, Boolean.FALSE);
    }

    private void historyOperations(History history, Boolean enable) {
        history.setEnable(enable);
        history.getProduct().setEnable(enable);
        this.historyDao.update(history);
    }

    @Override
    public List<History> getHistorysOfProduct(Product product) {
        return this.historyDao.getHistorysOfProduct(product);
    }
}
