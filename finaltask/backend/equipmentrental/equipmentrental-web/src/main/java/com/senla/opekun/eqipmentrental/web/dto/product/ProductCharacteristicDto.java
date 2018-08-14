package com.senla.opekun.eqipmentrental.web.dto.product;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class ProductCharacteristicDto {

    private Integer amount;
    private CharacteristicDto characteristic;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CharacteristicDto getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(CharacteristicDto characteristic) {
        this.characteristic = characteristic;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
