package com.example.qlst.controller;

import com.example.qlst.dao.CartItemDAO;
import com.example.qlst.dao.CustomerDAO;
import com.example.qlst.model.CartItem;
import com.example.qlst.model.Credential;
import com.example.qlst.model.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/customer")
public class CustomerController {
    private CustomerDAO customerDAO;
    public  CustomerController() {
        customerDAO = new CustomerDAO();
    }

    @POST
    @Path("/checkLogin")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Customer checkLogin(final Credential credential) {
        return customerDAO.checkLogin(credential.getUsername(), credential.getPassword());
    }

}
