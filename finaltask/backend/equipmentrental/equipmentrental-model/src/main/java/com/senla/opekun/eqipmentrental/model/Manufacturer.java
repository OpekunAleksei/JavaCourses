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
@Table(name = "manufacturers")
public class Manufacturer extends Model {

    private static final long serialVersionUID = 7631194264501456268L;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Product> products;
    @Column(name = "country_of_assembly", nullable = false)
    private String countryOfAssembly;
    @Column(name = "link", nullable = false)
    private String link;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Manufacturer() {
    }

    public Manufacturer(String name, List<Product> product, String countryOfAssembly, String link) {
        this.name = name;
        this.products = product;
        this.countryOfAssembly = countryOfAssembly;
        this.link = link;

    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public String getCountryOfAssembly() {
        return countryOfAssembly;
    }

    public void setCountryOfAssembly(String countryOfAssembly) {
        this.countryOfAssembly = countryOfAssembly;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
