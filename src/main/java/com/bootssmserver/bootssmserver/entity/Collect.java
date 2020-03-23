package com.bootssmserver.bootssmserver.entity;

public class Collect {
    private int cid;
    private String videoname;
    private String videopath;
    private String videocreater;
    private int vid;

    public Collect() {
    }

    public Collect(int cid,int vid,String videoname, String videopath, String videocreater) {
        this.cid = cid;
        this.vid = vid;
        this.videoname = videoname;
        this.videopath = videopath;
        this.videocreater = videocreater;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }

    public String getVideopath() {
        return videopath;
    }

    public void setVideopath(String videopath) {
        this.videopath = videopath;
    }

    public String getVideocreater() {
        return videocreater;
    }

    public void setVideocreater(String videocreater) {
        this.videocreater = videocreater;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }
}
