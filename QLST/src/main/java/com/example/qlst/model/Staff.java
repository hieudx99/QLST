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
public class Staff implements Serializable {
    private int id;
    private String username;
    private String password;
    private String position;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Staff(String username, String password, String position, String name, String phone, String email, String address) {
        this.username = username;
        this.password = password;
        this.position = position;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }


}
