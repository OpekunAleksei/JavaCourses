package com.senla.opekun.eqipmentrental.web.dto.product;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class ProductCategoryDto {

    private String title;
    private Long id;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
