package com.senla.opekun.eqipmentrental.web.dto.history;

import java.util.Date;

import com.senla.opekun.eqipmentrental.web.dto.product.ProductDto;
import com.senla.opekun.eqipmentrental.web.dto.user.UserDto;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class RequestHistoryDto {

    private Long id;
    private Date dateOfReceiving;
    private Date returnDate;
    private ProductDto product;
    private UserDto user;

    public Date getDateOfReceiving() {
	return dateOfReceiving;
    }

    public UserDto getUser() {
	return user;
    }

    public ProductDto getProduct() {
	return product;
    }

    public Long getId() {
	return id;
    }

    public Date getReturnDate() {
	return returnDate;
    }

    public void setDateOfReceiving(Date dateOfReceiving) {
	this.dateOfReceiving = dateOfReceiving;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setProduct(ProductDto product) {
	this.product = product;
    }

    public void setUser(UserDto user) {
	this.user = user;
    }

    public void setReturnDate(Date returnDate) {
	this.returnDate = returnDate;
    }

}
