package com.example.qlst.dao;

import com.example.qlst.model.Customer;
import com.example.qlst.model.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDAO extends DAO{
    public StaffDAO() {
        super();
    }

    public Staff checkLogin(String username, String password) {
        Staff staff = null;
        String sql = "SELECT * FROM tblStaff WHERE username = '" + username + "' AND password = '" + password +"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phoneNum = rs.getString("phoneNum");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String position = rs.getString("position");
                staff = new Staff(id, username, password, position, name, phoneNum, email, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staff;
    }
}
