package com.senla.opekun.eqipmentrental.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.senla.opekun.eqipmentrental.model.generic.Model;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Entity
@Table(name = "historys")
public class History extends Model {

    private static final long serialVersionUID = 7631194264501456268L;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false, nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Column(name = "date_of_receiving", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfReceiving;
    @Column(name = "return_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    @Column(name = "enable")
    private Boolean enable;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public History() {
    }

    public History(User user, Product product, Date dateOfReceiving, Date returnDate, Boolean enable) {
        this.user = user;
        this.product = product;
        this.dateOfReceiving = dateOfReceiving;
        this.returnDate = returnDate;
        this.enable = enable;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDateOfReceiving() {
        return dateOfReceiving;
    }

    public void setDateOfReceiving(Date dateOfReceiving) {
        this.dateOfReceiving = dateOfReceiving;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
