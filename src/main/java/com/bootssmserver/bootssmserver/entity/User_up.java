package com.bootssmserver.bootssmserver.entity;

public class User_up {
    private int uid;
    private int upid;
    private int isconcerned;
    private int isbothconcerned;//

    public User_up() {
    }

    public User_up(int uid, int upid) {
        this.uid = uid;
        this.upid = upid;
    }

    public User_up(int uid, int upid, int isconcerned, int isbothconcerned) {
        this.uid = uid;
        this.upid = upid;
        this.isconcerned = isconcerned;
        this.isbothconcerned = isbothconcerned;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUpid() {
        return upid;
    }

    public void setUpid(int upid) {
        this.upid = upid;
    }

    public int getIsconcerned() {
        return isconcerned;
    }

    public void setIsconcerned(int isconcerned) {
        this.isconcerned = isconcerned;
    }

    public int getIsbothconcerned() {
        return isbothconcerned;
    }

    public void setIsbothconcerned(int isbothconcerned) {
        this.isbothconcerned = isbothconcerned;
    }
}
