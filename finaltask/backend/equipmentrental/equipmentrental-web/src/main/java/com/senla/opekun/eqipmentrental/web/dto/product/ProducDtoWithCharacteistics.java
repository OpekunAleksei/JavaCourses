package com.senla.opekun.eqipmentrental.web.dto.product;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class ProducDtoWithCharacteistics {

    private Long id;
    private BigDecimal price;
    private Boolean enable;
    private String title;
    private List<ProductCharacteristicDto> productCharacteristic;

    public List<ProductCharacteristicDto> getProductCharacteristic() {
	return productCharacteristic;
    }

    public void setProductCharacteristic(List<ProductCharacteristicDto> productCharacteristic) {
	this.productCharacteristic = productCharacteristic;
    }

    public ProducDtoWithCharacteistics() {
    }

    public BigDecimal getPrice() {
	return price;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Long getId() {
	return id;
    }

    public void setPrice(BigDecimal price) {
	this.price = price;
    }

    public void setEnable(Boolean enable) {
	this.enable = enable;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getTitle() {
	return title;
    }

    public Boolean getEnable() {
	return enable;
    }

}
