package com.example.qlst.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart implements Serializable {
    private int id;
    private double total;
    private String paymentStat;
    private List<CartItem> listCartItem;
    private Customer customer;


    public ShoppingCart(double total, String paymentStat, Customer customer, List<CartItem> listCartItem) {
        this.total = total;
        this.paymentStat = paymentStat;
        this.customer = customer;
        this.listCartItem = listCartItem;
    }
    public ShoppingCart(int id, double total, String paymentStat, List<CartItem> listCartItem) {
        this.id = id;
        this.total = total;
        this.paymentStat = paymentStat;
        this.listCartItem = listCartItem;
    }


}
