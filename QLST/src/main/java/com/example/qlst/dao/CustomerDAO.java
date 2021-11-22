package com.example.qlst.dao;

import com.example.qlst.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO extends DAO{
    public CustomerDAO() {
        super();
    }

    public Customer checkLogin(String username, String password) {
        Customer customer = null;
        String sql = "SELECT * FROM tblCustomer WHERE username = '" + username + "' AND password = '" + password +"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phoneNum = rs.getString("phoneNum");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String description = rs.getString("description");
                customer = new Customer(id, username, password, name, phoneNum, email, address, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
