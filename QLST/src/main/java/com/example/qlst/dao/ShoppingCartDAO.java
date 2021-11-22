package com.example.qlst.dao;

import com.example.qlst.model.CartItem;
import com.example.qlst.model.Product;
import com.example.qlst.model.ShoppingCart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDAO extends DAO{
    ProductDAO productDAO;
    public ShoppingCartDAO() {
        super();
        productDAO = new ProductDAO();
    }
    public ShoppingCart getShoppingCart(int customerid) {
        ShoppingCart shoppingCart = null;
        List<CartItem> listCartItem = new ArrayList<>();
        int shoppingCartID = getShoppingCartIDByCusID(customerid);

        String sql1 = "SELECT * FROM tblCartItem WHERE shoppingcartid = '" + shoppingCartID + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                double total = rs.getDouble("total");
                String description = rs.getString("description");
                Product product = productDAO.getProductByID(rs.getInt("productid"));
                CartItem cartItem = new CartItem(id, quantity, total, description, product);
                listCartItem.add(cartItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql2 = "SELECT s.* FROM tblShoppingcart s WHERE s.customerid = " + customerid + " AND s.paymentStat = 'P'";
        try {
            PreparedStatement ps = con.prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            String paymentStat = rs.getString("paymentStat");
            double total = rs.getDouble("total");
            shoppingCart = new ShoppingCart(id,total, paymentStat, listCartItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCart;
    }

    public int getShoppingCartIDByCusID(int customerid) {
        int shoppingcartid = 0;
        String sql = "SELECT s.id FROM tblShoppingcart s WHERE s.customerid = " + customerid + " AND s.paymentStat = 'P'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            shoppingcartid = rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingcartid;
    }

    public boolean updateTotal(int shoppingcartid) {
        boolean result = false;
        double total = 0;
        String sql = "SELECT sum(total) total FROM tblcartitem WHERE shoppingcartid = '" + shoppingcartid + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (total > 0) {
            String sql2 = "UPDATE tblShoppingcart SET total = '" + total + "' WHERE id = '" + shoppingcartid + "'";
            try {
                PreparedStatement ps = con.prepareStatement(sql2);
                int res = ps.executeUpdate();
                if (res > 0) {
                    result = true;
                    return result;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return result;
    }

    public boolean createShoppingCart(int shoppingcartid, int customerid) {
        boolean result = false;
        String sql = "UPDATE tblShoppingCart SET paymentStat = 'S' WHERE id = '" + shoppingcartid + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int res = ps.executeUpdate();
            if (res <= 0) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        String sql2 = "INSERT INTO tblShoppingCart(paymentstat, total, customerid) values (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql2);
            ps.setString(1, "P");
            ps.setDouble(2, 0);
            ps.setInt(3, customerid);
            int res = ps.executeUpdate();
            if (res > 0) {
                result = true;
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;

    }

}
