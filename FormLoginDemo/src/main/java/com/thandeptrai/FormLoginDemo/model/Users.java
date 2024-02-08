package com.thandeptrai.FormLoginDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String roles;

    public Users() {
    }

    public Users(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}

