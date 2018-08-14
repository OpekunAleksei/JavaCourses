package com.senla.opekun.eqipmentrental.web.dto.product;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class ManufacturerDto {

    private String name;
    private String countryOfAssembly;
    private String link;
    private Long id;

    public String getCountryOfAssembly() {
        return countryOfAssembly;
    }

    public String getLink() {
        return link;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setCountryOfAssembly(String countryOfAssembly) {
        this.countryOfAssembly = countryOfAssembly;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
