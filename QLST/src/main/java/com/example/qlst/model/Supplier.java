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
public class Supplier implements Serializable {
    private int id;
    private String name;
    private String contactName;
    private String phoneNum;
    private String email;
    private String address;
    private String description;

    public Supplier(String name, String contactName, String phoneNum, String email, String address, String description) {
        this.name = name;
        this.contactName = contactName;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
        this.description = description;
    }

    public Supplier(int supplierid, String name, String address) {
        this.id = supplierid;
        this.name = name;
        this.address = address;
    }
}
