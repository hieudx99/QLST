package com.example.qlst.dao;

import com.example.qlst.model.SupplierStat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierStatDAO extends DAO{


    public List<SupplierStat> getListSupplierStat(String from, String to) {
        List<SupplierStat> listSupplierStat = new ArrayList<>();
        String sql = "select sum(total) total, a.supplierid, s.name, s.address, count(a.id) importTime " +
                "from tblimportbill a, tblsupplier s where date > '" + from + "' and date < '" + to +  "' and s.id = a.supplierid group by a.supplierid";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                double total = rs.getDouble("total");
                int supplierid = rs.getInt("supplierid");
                String name = rs.getString("name");
                String address =rs.getString("address");
                int importTime = rs.getInt("importTime");
                SupplierStat supplierStat = new SupplierStat(supplierid, name, address, importTime, total );
                listSupplierStat.add(supplierStat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSupplierStat;
    }
}
