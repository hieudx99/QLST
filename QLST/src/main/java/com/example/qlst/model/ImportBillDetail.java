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
public class ImportBillDetail implements Serializable {
    private int id;
    private int quantity;
    private double total;
    private String description;
    private Product product;

    public ImportBillDetail(int quantity, double total, String description, Product product) {
        this.quantity = quantity;
        this.total = total;
        this.description = description;
        this.product = product;
    }
}
