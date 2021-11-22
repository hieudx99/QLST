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
public class PaymentMethod implements Serializable {
    private int id;
    private String type;

    public PaymentMethod(String type) {
        this.type = type;
    }
}
