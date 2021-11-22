package com.example.qlst.controller;


import com.example.qlst.dao.CartItemDAO;
import com.example.qlst.dao.OrderBillDAO;
import com.example.qlst.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/orderbill")
public class OrderBillController {
    private OrderBillDAO orderBillDAO;
    public OrderBillController() {
        orderBillDAO = new OrderBillDAO();
    }
    @GET
    @Path("/checkVoucher/{code}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Voucher checkVoucher(@PathParam("code") String code) {
        Voucher voucher = orderBillDAO.checkVoucher(code);
        return voucher;
    }

    @GET
    @Path("/getPayment")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<PaymentMethod> getlistPayment() {
        List<PaymentMethod> listPayment = orderBillDAO.getListPayment();
        return listPayment;
    }

    @POST
    @Path("/addBill")
    @Consumes({ MediaType.APPLICATION_JSON})
    public boolean addBill(OrderBill orderBill) {
        return orderBillDAO.addBill(orderBill);
    }
}
