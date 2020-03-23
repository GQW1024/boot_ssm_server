package com.bootssmserver.bootssmserver.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Video {
    private int upid;
    private int vid;
    private int disid;//对应的评论id
    private String videoname;
    private String videotype;
    private String videoabstract;
    private String videoface;
    private String videopath;
    private int playcount;
    private int putcount;
    private int downcount;
    private int collectcount;
    private Date createdate;

    public Video() {
    }

    public Video(int upid, int vid, String videoname, String videotype, String videoabstract, String videoface, String videopath, int playcount, int putcount, int downcount, int collectcount) {
        this.upid = upid;
        this.vid = vid;
        this.videoname = videoname;
        this.videotype = videotype;
        this.videoabstract = videoabstract;
        this.videoface = videoface;
        this.videopath = videopath;
        this.playcount = playcount;
        this.putcount = putcount;
        this.downcount = downcount;
        this.collectcount = collectcount;
    }
    public Video(int upid, String videoname, String videotype, String videoabstract, int playcount, int putcount, int downcount, int collectcount, Date createdate) {
        this.upid = upid;
        this.vid = vid;
        this.videoname = videoname;
        this.videotype = videotype;
        this.videoabstract = videoabstract;
        this.playcount = playcount;
        this.putcount = putcount;
        this.downcount = downcount;
        this.collectcount = collectcount;
        this.createdate = createdate;
    }

    public Video(int vid, int disid, String videoface, String videopath) {
        this.vid = vid;
        this.disid = disid;
        this.videoface = videoface;
        this.videopath = videopath;
    }

    public int getUpid() {
        return upid;
    }

    public void setUpid(int upid) {
        this.upid = upid;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }

    public String getVideotype() {
        return videotype;
    }

    public void setVideotype(String videotype) {
        this.videotype = videotype;
    }

    public int getDisid() {
        return disid;
    }

    public void setDisid(int disid) {
        this.disid = disid;
    }

    public String getVideoabstract() {
        return videoabstract;
    }

    public void setVideoabstract(String videoabstract) {
        this.videoabstract = videoabstract;
    }

    public String getVideoface() {
        return videoface;
    }

    public void setVideoface(String videoface) {
        this.videoface = videoface;
    }

    public String getVideopath() {
        return videopath;
    }

    public void setVideopath(String videopath) {
        this.videopath = videopath;
    }

    public int getPlaycount() {
        return playcount;
    }

    public void setPlaycount(int playcount) {
        this.playcount = playcount;
    }

    public int getPutcount() {
        return putcount;
    }

    public void setPutcount(int putcount) {
        this.putcount = putcount;
    }

    public int getDowncount() {
        return downcount;
    }

    public void setDowncount(int downcount) {
        this.downcount = downcount;
    }

    public int getCollectcount() {
        return collectcount;
    }

    public void setCollectcount(int collectcount) {
        this.collectcount = collectcount;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
