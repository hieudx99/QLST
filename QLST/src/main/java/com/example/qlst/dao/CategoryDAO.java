package com.example.qlst.dao;

import com.example.qlst.model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO extends DAO{
    public CategoryDAO() {
        super();
    }

    public Category getCategoryByID(int id) {
        Category category = null;
        String sql = "SELECT * FROM tblCategory WHERE id = '" + id + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String name = rs.getString("name");
            String image = rs.getString("image");
            String description = rs.getString("description");
            category = new Category(id, name, image, description);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
