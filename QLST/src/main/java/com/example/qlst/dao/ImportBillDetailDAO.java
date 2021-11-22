package com.example.qlst.dao;

import com.example.qlst.model.ImportBillDetail;
import com.example.qlst.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImportBillDetailDAO extends DAO{
    ProductDAO productDAO;
    public ImportBillDetailDAO() {
        productDAO = new ProductDAO();
    }
    public List<ImportBillDetail> getListImportBillDetail(int billid) {
        List<ImportBillDetail> listImportBillDetail = new ArrayList<>();
        String sql = "SELECT * FROM tblImportBillDetail WHERE importbillid = '" + billid + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                double total = rs.getDouble("total");
                String description = rs.getString("description");
                int productid = rs.getInt("productid");
                Product product = productDAO.getProductByID(productid);
                ImportBillDetail importBillDetail = new ImportBillDetail(id, quantity, total, description, product);
                listImportBillDetail.add(importBillDetail);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return listImportBillDetail;
    }
}
