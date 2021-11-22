package com.example.qlst.dao;

import com.example.qlst.model.Category;
import com.example.qlst.model.Product;
import com.example.qlst.model.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDAO extends DAO{
    public SupplierDAO() {
        super();
    }

    public Supplier getSupplierByID(int supplierid) {
        Supplier supplier = null;
        String sql = "SELECT p.* FROM tblSupplier p WHERE p.id = '" + supplierid + "'" ;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            //int id = rs.getInt("id");
            String name = rs.getString("name");
            String contactName = rs.getString("contactName");
            String phoneNum = rs.getString("phoneNum");
            String email = rs.getString("email");
            String address = rs.getString("address");
            String description = rs.getString("description");
            supplier = new Supplier(supplierid, name, contactName, phoneNum, email, address, description);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplier;
    }
}

