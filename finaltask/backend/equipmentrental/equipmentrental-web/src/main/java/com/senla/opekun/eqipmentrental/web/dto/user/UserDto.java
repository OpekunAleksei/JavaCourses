package com.senla.opekun.eqipmentrental.web.dto.user;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class UserDto {

    private String nickname;
    private Long id;
    private RoleDto role;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public RoleDto getRole() {
        return role;
    }

    public String getNickname() {
        return nickname;
    }

    public Long getId() {
        return id;
    }

}
