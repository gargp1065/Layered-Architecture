package com.example.layered_oaes.service;

import com.example.layered_oaes.bean.MCQ;
import com.example.layered_oaes.bean.MCQListWrapper;
import com.example.layered_oaes.dao.AdminDAO;
import com.example.layered_oaes.dao.AuthorDAO;
import com.example.layered_oaes.dao.McqDAO;

import java.util.List;

public class McqService {
    AdminDAO ad = new AdminDAO();
    AuthorDAO au = new AuthorDAO();
    McqDAO mcq = new McqDAO();
    public boolean addMCQ(MCQ dto) {
        return mcq.addMCQ(dto);
    }
    public List<MCQ> getMCQ(MCQListWrapper wrapper) {
        return mcq.getMCQ(wrapper);
    }
}