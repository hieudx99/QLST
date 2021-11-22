package com.example.qlst.controller;

import com.example.qlst.dao.SupplierStatDAO;
import com.example.qlst.model.Credential;
import com.example.qlst.model.Customer;
import com.example.qlst.model.SupplierStat;
import com.example.qlst.model.SupportStat;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/suplierstat")
public class SupplierStatController {
    SupplierStatDAO supplierStatDAO;

    public SupplierStatController() {
        supplierStatDAO = new SupplierStatDAO();
    }

    @POST
    @Path("/getListSupplierStat")
    @Consumes({ MediaType.APPLICATION_JSON})
    public List<SupplierStat> getListSupplierStat(final SupportStat supportStat) {
        return supplierStatDAO.getListSupplierStat(supportStat.getFrom(), supportStat.getTo());
    }
}
