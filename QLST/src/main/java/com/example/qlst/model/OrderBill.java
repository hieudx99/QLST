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
public class OrderBill implements Serializable {
    private int id;
    private String date;
    private double total;
    private String bill_type;
    private String ship_to;
    private String ship_stat;
    private String payment_stat;
    private PaymentMethod paymentMethod;
    private Voucher voucher;
    private Shipper shipper;
    private Staff checker;
    private ShoppingCart shoppingCart;
    private Customer customer;

    public OrderBill(String date, double total, String bill_type, String ship_to, String ship_stat, String payment_stat, PaymentMethod paymentMethod, Voucher voucher, Shipper shipper, Staff checker, ShoppingCart shoppingCart, Customer customer) {
        this.date = date;
        this.total = total;
        this.bill_type = bill_type;
        this.ship_to = ship_to;
        this.ship_stat = ship_stat;
        this.payment_stat = payment_stat;
        this.paymentMethod = paymentMethod;
        this.voucher = voucher;
        this.shipper = shipper;
        this.checker = checker;
        this.shoppingCart = shoppingCart;
        this.customer = customer;
    }
}
