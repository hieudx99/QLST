package com.example.qlst.controller;

import com.example.qlst.dao.CustomerDAO;
import com.example.qlst.dao.StaffDAO;
import com.example.qlst.model.Credential;
import com.example.qlst.model.Customer;
import com.example.qlst.model.Staff;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/manager")
public class StaffController {
    private StaffDAO staffDAO;
    public  StaffController() {
        staffDAO = new StaffDAO();
    }

    @POST
    @Path("/checkLogin")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Staff checkLogin(final Credential credential) {
        return staffDAO.checkLogin(credential.getUsername(), credential.getPassword());
    }
}
