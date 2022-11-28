package com.example.layered_oaes.dao;

import com.example.layered_oaes.bean.Admin;
import com.example.layered_oaes.bean.Author;
import com.example.layered_oaes.util.DbData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthorDAO {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public boolean loginAuthor(Author user) {
        boolean flag = false;
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "select * from author where username = ? && password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            rs = ps.executeQuery();
            if(rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception in loginAuthor :" + e.getMessage());
        } finally {
            ps = null;
            con = null;
            return flag;
        }
    }
    public boolean addAuthor(Author dto) {
        boolean flag = false;
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "Insert into author(username,password) values(?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, dto.getUsername());
            ps.setString(2, dto.getPassword());
            if(ps.executeUpdate()>0) {
                flag=true;
            }
        } catch (Exception e) {
            System.out.println("Exception in addAuthor :" + e.getMessage());
        } finally {
            ps = null;
            con = null;
            return flag;
        }
    }
}
