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
public class SupplierStat extends Supplier implements Serializable  {
    private int importTime;
    private double importAmount;

    public SupplierStat(int supplierid, String name, String address, int importTime, double total) {
        super(supplierid, name, address);
        this.importAmount = total;
        this.importTime = importTime;
    }
}
