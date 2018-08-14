package com.senla.opekun.eqipmentrental.web.dto.product;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class CharacteristicDto {

    private Long id;
    private String name;

    public CharacteristicDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CharacteristicDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
