package com.example.qlst.controller;

import com.example.qlst.dao.CartItemDAO;
import com.example.qlst.model.CartItem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/cart-item")
public class CartItemController {
    @POST
    @Path("/{customerid}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public boolean addCartItem(CartItem cartItem,@PathParam("customerid") int customerid) {
        CartItemDAO cartItemDAO = new CartItemDAO();
        return cartItemDAO.addCartItem(cartItem,customerid);
    }

    @GET
    public String test() {
        return "test";
    }
}
