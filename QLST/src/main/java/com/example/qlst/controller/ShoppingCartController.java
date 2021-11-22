package com.example.qlst.controller;


import com.example.qlst.dao.ShoppingCartDAO;
import com.example.qlst.model.ShoppingCart;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/shoppingcart")
public class ShoppingCartController {
    private ShoppingCartDAO shoppingCartDAO;
    public ShoppingCartController() {
        shoppingCartDAO = new ShoppingCartDAO();
    }
    @GET
    @Path("/{customerid}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ShoppingCart getShoppingCartByID(@PathParam("customerid") int customerid) {
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCart(customerid);
        return shoppingCart;
    }
}
