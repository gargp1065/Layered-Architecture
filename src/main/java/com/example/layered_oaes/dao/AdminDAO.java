package com.example.layered_oaes.dao;

import com.example.layered_oaes.bean.Admin;
import com.example.layered_oaes.util.DbData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public boolean loginAdmin(Admin user) {
        boolean flag = false;
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            if(user == null){
                System.out.println("HELLO");
            }
            String query = "select * from admin where username = ? && password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            rs = ps.executeQuery();
            if(rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception in loginAdmin :" + e.getMessage());
        } finally {
            ps = null;
            con = null;
            return flag;
        }
    }
}
