package com.example.qlst.dao;

import com.example.qlst.model.ImportBill;
import com.example.qlst.model.ImportBillDetail;
import com.example.qlst.model.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImportBillDAO extends DAO{
    SupplierDAO supplierDAO;
    ImportBillDetailDAO importBillDetailDAO;
    public ImportBillDAO() {
        super();
        supplierDAO = new SupplierDAO();
        importBillDetailDAO = new ImportBillDetailDAO();
    }
    public List<ImportBill> getImportHistory(String from, String to, int supplierid) {
        List<ImportBill> listImportBill = new ArrayList<>();
        String sql = "SELECT * FROM tblImportBill WHERE date > '" + from + "' and date < '" + to + "' and supplierid = '" + supplierid + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("date");
                double total = rs.getDouble("total");
                Supplier supplier = supplierDAO.getSupplierByID(supplierid);
                ImportBill importBill = new ImportBill(id, date, total, supplier);
                listImportBill.add(importBill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listImportBill;
    }

    public ImportBill getBillDetail(int billid)  {
        ImportBill importBill = null;
        String sql = "SELECT * FROM tblImportBill WHERE id = '" + billid + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String date = rs.getString("date");
                double total = rs.getDouble("total");
                List<ImportBillDetail> listImportBillDetail = importBillDetailDAO.getListImportBillDetail(billid);
                importBill = new ImportBill();
                importBill.setId(billid);
                importBill.setDate(date);
                importBill.setListImportBillDetail(listImportBillDetail);
                importBill.setTotal(total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return importBill;
    }
}
