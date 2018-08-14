package com.senla.opekun.eqipmentrental.web.dto.user;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class PersonDto {

    private String firstName;
    private String secondName;
    private Long id;
    private String email;
    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
