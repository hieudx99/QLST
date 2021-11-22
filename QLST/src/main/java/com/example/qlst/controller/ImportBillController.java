package com.example.qlst.controller;

import com.example.qlst.dao.CustomerDAO;
import com.example.qlst.dao.ImportBillDAO;
import com.example.qlst.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/importbill")
public class ImportBillController {
    private ImportBillDAO importBillDAO;
    public  ImportBillController() {
        importBillDAO = new ImportBillDAO();
    }

    @POST
    @Path("/getImportHistory/{supplierid}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public List<ImportBill> getImportHistory(final SupportStat supportStat, @PathParam("supplierid") int supplierid) {
        return importBillDAO.getImportHistory(supportStat.getFrom(), supportStat.getTo(), supplierid);
    }

    @GET
    @Path("/getBillDetail/{billid}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ImportBill getProductByID(@PathParam("billid") int billid) {
        ImportBill importBill = importBillDAO.getBillDetail(billid);
        return importBill;
    }
}
