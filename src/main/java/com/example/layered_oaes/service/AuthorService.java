package com.example.layered_oaes.service;

import com.example.layered_oaes.bean.Admin;
import com.example.layered_oaes.bean.Author;
import com.example.layered_oaes.dao.AuthorDAO;

public class AuthorService {
    AuthorDAO ad = new AuthorDAO();
    public boolean addAuthor(Author user) {
        return ad.addAuthor(user);
    }
}
