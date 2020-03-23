package com.bootssmserver.bootssmserver.entity;

public class Useraction {
    private int vid;
    private int uid;
    private int up;
    private int down;
    private int collect;

    public Useraction() {
    }

    public Useraction(int vid, int uid) {
        this.vid = vid;
        this.uid = uid;
    }

    public Useraction(int vid, int uid, int up, int down, int collect) {
        this.vid = vid;
        this.uid = uid;
        this.up = up;
        this.down = down;
        this.collect = collect;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }
}
