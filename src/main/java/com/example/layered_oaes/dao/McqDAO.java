package com.example.layered_oaes.dao;

import com.example.layered_oaes.bean.MCQ;
import com.example.layered_oaes.bean.MCQListWrapper;
import com.example.layered_oaes.util.DbData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class McqDAO {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public boolean addMCQ(MCQ dto) {
        boolean flag = false;
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "Insert into item(question,correctAnswer,subject,author_id) values(?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, dto.getQuestion());
            ps.setString(2, dto.getCorrectAnswer());
            ps.setString(3, dto.getSubject());
            ps.setInt(4, dto.getAuthorId());
            if(ps.executeUpdate()>0) {
                flag=true;
            }
            query = "select * from item";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            int item_id = -1;
            while(rs.next()) {
                if(dto.getQuestion().equals(rs.getString("question"))){
                    item_id = rs.getInt("item_id");
                    break;
                }
            }
            query = "Insert into mcq(option1,option2,option3,option4,item_id) values(?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, dto.getOptionA());
            ps.setString(2, dto.getOptionB());
            ps.setString(3, dto.getOptionC());
            ps.setString(4, dto.getOptionD());
            ps.setInt((int)5,item_id);
            if(ps.executeUpdate()>0) {
                flag=true;
            }
        } catch (Exception e) {
            System.out.println("Exception in addMCQ :" + e.getMessage());
        } finally {
            ps = null;
            con = null;
            return flag;
        }
    }
    public List<MCQ> getMCQ(MCQListWrapper wrapper) {
        List<MCQ> ans = new ArrayList<MCQ>();
        System.out.println(wrapper.getSubject()+"getMCQDAO");
        try {
            String subject = wrapper.getSubject();
            int count = wrapper.getCount();
//            int count = Integer.valueOf(counts);
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "select * from item NATURAL JOIN mcq";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                if(!rs.getString("subject").equals(subject)){
                    continue;
                }
                MCQ dto = null;
                dto = new MCQ();
                dto.setSubject(rs.getString("subject"));
                dto.setQuestion(rs.getString("question"));
                dto.setCorrectAnswer(rs.getString("correctAnswer"));
                dto.setOptionA(rs.getString("option1"));
                dto.setOptionB(rs.getString("option2"));
                dto.setOptionC(rs.getString("option3"));
                dto.setOptionD(rs.getString("option4"));
                ans.add(dto);
                count--;
                if(count == 0){
                    break;
                }
            }
            return ans;
        } catch (Exception e) {
            System.out.println("Exception in viewUser : "+e);
        } finally {
            rs=null;
            ps = null;
            con = null;
            return ans;
        }
    }
}