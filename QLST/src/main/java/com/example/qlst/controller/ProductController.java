package com.example.qlst.controller;

import com.example.qlst.dao.ProductDAO;
import com.example.qlst.model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/product")
public class ProductController {
    private ProductDAO productDAO;
    public ProductController() {
        productDAO = new ProductDAO();
    }

    @GET
    @Path("/test")
    public String test() {
        return "get all product";
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Product> getAllProduct() {
        List<Product> productList = productDAO.getAllProduct();
        return productList;
    }
    @GET
    @Path("/getByName/{keyword}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Product> getProductByName(@PathParam("keyword") String keyword) {
        List<Product> productList = productDAO.getProductByName(keyword);
        return productList;
    }

    @GET
    @Path("/getByID/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Product getProductByID(@PathParam("id") int id) {
        Product product = productDAO.getProductByID(id);
        return product;
    }

}
