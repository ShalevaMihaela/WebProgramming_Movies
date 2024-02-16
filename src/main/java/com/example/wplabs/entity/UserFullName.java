package com.example.wplabs.entity;

import java.io.Serializable;

public class UserFullName implements Serializable {

    private String name;

    private String surname;

    public UserFullName(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
