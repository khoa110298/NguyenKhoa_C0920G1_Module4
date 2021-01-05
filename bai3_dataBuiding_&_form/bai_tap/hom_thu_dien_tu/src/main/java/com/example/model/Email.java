package com.example.model;

public class Email {
    private String languege;
    private String page;
    private boolean spams;
    private String signature;

    public Email() {
    }

    public Email(String languege, String page, boolean spams, String signature) {
        this.languege = languege;
        this.page = page;
        this.spams = spams;
        this.signature = signature;
    }

    public String getLanguege() {
        return languege;
    }

    public void setLanguege(String languege) {
        this.languege = languege;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public boolean isSpams() {
        return spams;
    }

    public void setSpams(boolean spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
