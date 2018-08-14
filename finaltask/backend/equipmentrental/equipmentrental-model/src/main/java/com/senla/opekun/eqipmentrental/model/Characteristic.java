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
@Table(name = "characteristics")
public class Characteristic extends Model {

    private static final long serialVersionUID = 7631194264501456268L;
    @OneToMany(mappedBy = "characteristic", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ProductCharacteristic> productCharacteristics;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Characteristic() {
    }

    public Characteristic(List<ProductCharacteristic> productCharacteristics, String name) {
        this.productCharacteristics = productCharacteristics;
        this.name = name;
    }

    public void setProductCharacteristics(List<ProductCharacteristic> productCharacteristics) {
        this.productCharacteristics = productCharacteristics;
    }

    public List<ProductCharacteristic> getProductCharacteristics() {
        return productCharacteristics;
    }

    public Characteristic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
