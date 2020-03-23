package com.bootssmserver.bootssmserver.entity;

import java.sql.Date;

public class Disscuss {
    private int disid;
    private int uid;
    private int vid;
    private String disscussmessage;
    private Date disdate;
    private int disupcount;
    private int disdowncount;

    public int getDisid() {
        return disid;
    }

    public void setDisid(int disid) {
        this.disid = disid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getDisscussmessage() {
        return disscussmessage;
    }

    public void setDisscussmessage(String disscussmessage) {
        this.disscussmessage = disscussmessage;
    }

    public Date getDisdate() {
        return disdate;
    }

    public void setDisdate(Date disdate) {
        this.disdate = disdate;
    }

    public int getDisupcount() {
        return disupcount;
    }

    public void setDisupcount(int disupcount) {
        this.disupcount = disupcount;
    }

    public int getDisdowncount() {
        return disdowncount;
    }

    public void setDisdowncount(int disdowncount) {
        this.disdowncount = disdowncount;
    }
}
