package com.senla.opekun.eqipmentrental.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.senla.opekun.eqipmentrental.model.generic.Model;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Entity
@Table(name = "products_category")
public class ProductCategory extends Model {

    @Column(name = "name", unique = true, nullable = false)
    private String title;
    private static final long serialVersionUID = 6875657231396402716L;
    @OneToMany(mappedBy = "productCategory", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Product> products;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public ProductCategory() {
    }

    public ProductCategory(String name, List<Product> product) {
        this.title = name;
        this.products = product;
    }

    public String getTitle() {
        return title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setTitle(String title) {
        this.title = title;
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
