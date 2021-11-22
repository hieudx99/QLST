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
public class ImportBill implements Serializable {
    private int id;
    private String date;
    private double total;
    private PaymentMethod paymentMethod;
    private List<ImportBillDetail> listImportBillDetail;
    private Supplier supplier;
    private Staff creator;



    public ImportBill(String date, double total, PaymentMethod paymentMethod, Supplier supplier, Staff creator, List<ImportBillDetail> importBillDetailList) {
        this.date = date;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.supplier = supplier;
        this.creator = creator;
        this.listImportBillDetail = importBillDetailList;
    }

    public ImportBill(int id, String date, double total, Supplier supplier) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.supplier= supplier;

    }
}
