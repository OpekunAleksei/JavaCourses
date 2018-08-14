package com.senla.opekun.eqipmentrental.web.dto.history;

import java.util.Date;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class HistoryDto {

    private Long id;
    private Date dateOfReceiving;
    private Date returnDate;

    public Date getDateOfReceiving() {
	return dateOfReceiving;
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

    public void setReturnDate(Date returnDate) {
	this.returnDate = returnDate;
    }

}
