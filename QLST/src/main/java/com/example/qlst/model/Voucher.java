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
public class Voucher implements Serializable {
    private int id;
    private String code;
    private int discount;
    private String status;
    private String description;

    public Voucher(int discount, String code, String status) {
        this.discount = discount;
        this.code = code;
        this.status = status;
    }
}
