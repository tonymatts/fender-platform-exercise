package com.fender.authorizeservice.dal.entity;

import javax.persistence.*;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String token;

    public UserEntity () {
    }

    public UserEntity (String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public String getEmail () {
        return email;
    }

    public String getPassword () {
        return password;
    }

    public String getToken () {
        return token;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public void setToken (String token) {
        this.token = token;
    }
}
