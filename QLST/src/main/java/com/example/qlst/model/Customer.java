package com.example.qlst.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    private int id;
    private String username;
    private String password;
    private String name;
    private String phoneNum;
    private String email;
    private String address;
    private String description;

    public Customer(String username, String password, String name, String phoneNum, String email, String address, String description) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
        this.description = description;
    }
}
