package com.senla.opekun.eqipmentrental.web.dto.product;

import java.math.BigDecimal;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class ProductDto {

    private Long id;
    private BigDecimal price;
    private Boolean enable;
    private String title;
    private ProductCategoryDto productCategory;

    public ProductDto() {
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

    public ProductCategoryDto getProductCategory() {
	return productCategory;
    }

    public void setProductCategory(ProductCategoryDto productCategory) {
	this.productCategory = productCategory;
    }

   

}
