package com.example.layered_oaes.bean;

public class MCQListWrapper {
    private String subject;
    private int count;
    public MCQListWrapper(){}

    public MCQListWrapper(String subject, int count) {
        this.subject = subject;
        this.count = count;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
