package com.example.layered_oaes.service;

import com.example.layered_oaes.bean.MCQ;
import com.example.layered_oaes.bean.MCQListWrapper;

import java.util.ArrayList;
import java.util.List;

public class McqServiceProxy {
    McqService mcq = new McqService();
    public boolean addMCQ(MCQ dto) {
        if(dto.getAuthorId() < 1){
            return false;
        }
        return mcq.addMCQ(dto);
    }
    public List<MCQ> getMCQ(MCQListWrapper wrapper) {
        if(wrapper.getSubject() == "" || wrapper.getSubject() == null){
            return new ArrayList<>();
        }
        return mcq.getMCQ(wrapper);
    }
}