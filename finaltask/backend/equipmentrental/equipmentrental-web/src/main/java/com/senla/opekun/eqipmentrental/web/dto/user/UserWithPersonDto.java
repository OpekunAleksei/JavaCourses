package com.senla.opekun.eqipmentrental.web.dto.user;

public class UserWithPersonDto {

    private String login;
    private String nickname;
    private PersonDto person;
    private Long id;
    private RoleDto role;

    public String getNickname() {
        return nickname;
    }

    public RoleDto getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }


    public String getLogin() {
        return login;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public void setPerson(PersonDto person) {
        this.person = person;
    }

}

