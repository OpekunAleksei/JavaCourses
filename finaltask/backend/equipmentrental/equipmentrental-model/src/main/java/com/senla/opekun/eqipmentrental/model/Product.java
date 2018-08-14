package com.senla.opekun.eqipmentrental.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.senla.opekun.eqipmentrental.model.generic.Model;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Entity
@Table(name = "products")
public class Product extends Model {

    private static final long serialVersionUID = -7881391014358935700L;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", updatable = false, nullable = false)
    private ProductCategory productCategory;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<History> history;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id", updatable = false, nullable = false)
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.PERSIST,
	    CascadeType.MERGE })
    private List<ProductCharacteristic> productCharacteristic;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "title", unique = true, nullable = false)
    private String title;
    @Column(name = "enable", nullable = false)
    private Boolean enable;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Product() {
    }

    public Product(ProductCategory productCategory, Manufacturer manufacturer,
	    List<ProductCharacteristic> productCharacteristic, BigDecimal price, String title, Boolean enable) {
	this.productCategory = productCategory;
	this.manufacturer = manufacturer;
	this.productCharacteristic = productCharacteristic;
	this.price = price;
	this.title = title;
	this.enable = enable;
    }

    public void setHistory(List<History> history) {
	this.history = history;
    }

    public List<History> getHistory() {
	return history;
    }

    public void setEnable(Boolean enable) {
	this.enable = enable;
    }

    public Boolean getEnable() {
	return enable;
    }

    public List<ProductCharacteristic> getProductCharacteristic() {
	return productCharacteristic;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getTitle() {
	return title;
    }

    public void setProductCharacteristic(List<ProductCharacteristic> productCharacteristic) {
	this.productCharacteristic = productCharacteristic;
    }

    public Manufacturer getManufacturer() {
	return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
	this.manufacturer = manufacturer;
    }

    public ProductCategory getProductCategory() {
	return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
	this.productCategory = productCategory;
    }

    public BigDecimal getPrice() {
	return price;
    }

    public void setPrice(BigDecimal price) {
	this.price = price;
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
