package com.example.qlst.dao;

import com.example.qlst.model.OrderBill;
import com.example.qlst.model.PaymentMethod;
import com.example.qlst.model.Voucher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class OrderBillDAO extends DAO{
    private ProductDAO productDAO;
    private ShoppingCartDAO shoppingCartDAO;
    public OrderBillDAO() {
        super();
        shoppingCartDAO = new ShoppingCartDAO();
        productDAO = new ProductDAO();
    }

    public Voucher checkVoucher(String code) {
        Voucher voucher = null;
        String sql = "SELECT * FROM tblVoucher WHERE code = '" + code + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                int discount = rs.getInt("discount");
                String description = rs.getString("description");
                String status = rs.getString("status");
                voucher = new Voucher(id, code, discount, status, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voucher;
    }

    public List<PaymentMethod> getListPayment() {
        List<PaymentMethod> listPayment  = new ArrayList<>();
        String sql = "SELECT * FROM tblPayment";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                PaymentMethod p = new PaymentMethod(id, type);
                listPayment.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPayment;
    }

    public boolean addBill(OrderBill orderBill) {
        boolean result = false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        List<PaymentMethod> listPayment = getListPayment();
        for (PaymentMethod p : listPayment) {
            if (p.getType().equalsIgnoreCase(orderBill.getPaymentMethod().getType())) {
                orderBill.getPaymentMethod().setId(p.getId());
            }
        }

        String sql = "INSERT INTO tblOrderBill(date, total, bill_type, description, ship_to, payment_stat, ship_stat, " +
                "paymentid, shoppingcartid, customerid) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, date);
            ps.setDouble(2, orderBill.getTotal());
            ps.setString(3, orderBill.getBill_type());
            ps.setString(4, "");
            ps.setString(5, orderBill.getShip_to());
            ps.setString(6, orderBill.getPayment_stat());
            ps.setString(7, orderBill.getShip_stat());
            //ps.setInt(8, orderBill.getVoucher().getId());
            ps.setInt(8, orderBill.getPaymentMethod().getId());
            ps.setInt(9, orderBill.getShoppingCart().getId());
            ps.setInt(10, orderBill.getCustomer().getId());
            int res = ps.executeUpdate();
            if (res > 0) {
                result = true;
                shoppingCartDAO.createShoppingCart(orderBill.getShoppingCart().getId(), orderBill.getCustomer().getId());
                return  result;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
