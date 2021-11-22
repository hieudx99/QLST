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
public class CartItem implements Serializable {
    private int id;
    private int quantity;
    private double total;
    private String description;
    private Product product;

    public CartItem(int quantity, double total, Product product, String description) {
        this.quantity = quantity;
        this.total = total;
        this.product = product;
        this.description = description;
    }

}
