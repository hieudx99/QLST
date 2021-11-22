package com.example.qlst.dao;

import com.example.qlst.model.Category;
import com.example.qlst.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DAO{
    private CategoryDAO categoryDAO;
    public ProductDAO() {
        super();
        categoryDAO = new CategoryDAO();
    }

    public List<Product> getAllProduct() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM tblProduct";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double unitPrice = rs.getDouble("unitPrice");
                int nbr_sold = rs.getInt("nbr_sold");
                int nbr_left = rs.getInt("nbr_left");
                String description = rs.getString("description");
                int size = rs.getInt("size");
                String color = rs.getString("color");
                String image = rs.getString("image");
                int categoryid = rs.getInt("categoryid");
                Category category = getCategoryByID(categoryid);
                Product product = new Product(id, name, unitPrice, nbr_sold, nbr_left, description, size, color, image, category);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
        }

        return productList;
    }

    public List<Product> getProductByName(String keyword) {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM tblProduct p WHERE p.name like ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double unitPrice = rs.getDouble("unitPrice");
                int nbr_sold = rs.getInt("nbr_sold");
                int nbr_left = rs.getInt("nbr_left");
                String description = rs.getString("description");
                int size = rs.getInt("size");
                String color = rs.getString("color");
                String image = rs.getString("image");
                int categoryid = rs.getInt("categoryid");
                Category category = getCategoryByID(categoryid);
                Product product = new Product(id, name, unitPrice, nbr_sold, nbr_left, description, size, color, image, category);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public Product getProductByID(int id) {
        Product product = null;
        String sql = "SELECT p.* FROM tblProduct p WHERE p.id = '" + id + "'" ;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            //int id = rs.getInt("id");
            String name = rs.getString("name");
            double unitPrice = rs.getDouble("unitPrice");
            int nbr_sold = rs.getInt("nbr_sold");
            int nbr_left = rs.getInt("nbr_left");
            String description = rs.getString("description");
            int size = rs.getInt("size");
            String color = rs.getString("color");
            String image = rs.getString("image");
            int categoryid = rs.getInt("categoryid");
            Category category = getCategoryByID(categoryid);
            product = new Product(id, name, unitPrice, nbr_sold, nbr_left, description, size, color, image, category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
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

    public boolean updateQty(int productid, int nbr_sold, int nbr_left) {
        boolean result = false;
        nbr_sold++;
        nbr_left--;
        String sql = "UPDATE tblProduct SET nbr_sold = '" + nbr_sold + "', nbr_left = '" + nbr_left + "' WHERE id = '" + productid + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int res = ps.executeUpdate();
            if (res > 0) {
                result = true;
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return result;
    }
}
