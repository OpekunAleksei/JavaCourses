/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends AEntity {

    @Column(name = "token")
    private String token;
    @Column(name = "password")
    private Integer password;
    @Column(name = "login")
    private String login;
    @Column(name = "iduser")
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private Integer id;

    public Client(Integer password, String login) {
        this.password = password;
        this.login = login;
        this.id = null;
        this.token = null;
    }

    public Client() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
