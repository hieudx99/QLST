package com.example.qlst.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shipper implements Serializable {
    private int id;
    private String name;
    private String phoneNum;
    private String companyName;
    private String address;

    public Shipper(String name, String phoneNum, String companyName, String address) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.companyName = companyName;
        this.address = address;
    }

}
