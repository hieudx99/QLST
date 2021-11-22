package com.example.qlst.dao;

import com.example.qlst.model.CartItem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItemDAO extends DAO{
    private ShoppingCartDAO shoppingCartDAO;
    public CartItemDAO() {
        super();
        shoppingCartDAO = new ShoppingCartDAO();
    }

    public boolean addCartItem(CartItem cartItem,int customerid) {
        int shoppingcartid = shoppingCartDAO.getShoppingCartIDByCusID(customerid);
        if (shoppingcartid <= 0) {
            return false;
        }
        String sql = "INSERT into tblCartItem(quantity, total, description, productid, shoppingcartid) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cartItem.getQuantity());
            ps.setDouble(2, cartItem.getTotal());
            ps.setString(3, cartItem.getDescription());
            ps.setInt(4, cartItem.getProduct().getId());
            ps.setInt(5, shoppingcartid);
            int res = ps.executeUpdate();
            if (res > 0) {
                boolean resultUpdate = shoppingCartDAO.updateTotal(shoppingcartid);
                if (resultUpdate == true) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
