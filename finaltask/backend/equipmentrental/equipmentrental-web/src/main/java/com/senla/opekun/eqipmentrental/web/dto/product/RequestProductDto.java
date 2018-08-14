package com.senla.opekun.eqipmentrental.web.dto.product;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class RequestProductDto {

    private Long id;
    private BigDecimal price;
    private Boolean enable;
    private String title;
    private ManufacturerDto manufacturer;
    private ProductCategoryDto productCategory;
    private List<ProductCharacteristicDto> productCharacteristic;

    public List<ProductCharacteristicDto> getProductCharacteristic() {
        return productCharacteristic;
    }

    public ProductCategoryDto getProductCategory() {
        return productCategory;
    }

    public ManufacturerDto getManufacturer() {
        return manufacturer;
    }

    public void setProductCharacteristic(List<ProductCharacteristicDto> productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
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

    public void setProductCategory(ProductCategoryDto productCategory) {
        this.productCategory = productCategory;
    }

    public void setManufacturer(ManufacturerDto manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Boolean getEnable() {
        return enable;
    }

}
