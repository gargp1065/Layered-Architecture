package com.example.layered_oaes.service;

import com.example.layered_oaes.bean.Admin;
import com.example.layered_oaes.bean.Author;
import com.example.layered_oaes.dao.AdminDAO;
import com.example.layered_oaes.dao.AuthorDAO;

public class AuthService {
    AdminDAO ad = new AdminDAO();
    AuthorDAO au = new AuthorDAO();
    public boolean loginAdmin(Admin user) {
        return ad.loginAdmin(user);
    }
    public boolean authorLogin(Author user) {
        return au.loginAuthor(user);
    }

}
