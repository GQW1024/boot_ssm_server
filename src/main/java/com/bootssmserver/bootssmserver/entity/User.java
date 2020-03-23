package com.bootssmserver.bootssmserver.entity;


public class User {
    private int uid;    //用户编号
    private String username;    //用户昵称
    private String useraccnum;    //用户账号
    private String userfacepath;
    private String userpass;    //用户密码
    private int upid;   //用户得作者编号
    private int cid;    //收藏夹id
    private int isregister; //是否登录
    private int fancount;   //粉丝数

    public User() {
    }

    public User(int uid, String username, String userfacepath, String useraccnum, String userpass, int upid, int cid, int isregister, int fancount) {
        this.uid = uid;
        this.username = username;
        this.userfacepath = userfacepath;
        this.useraccnum = useraccnum;
        this.userpass = userpass;
        this.upid = upid;
        this.cid = cid;
        this.isregister = isregister;
        this.fancount = fancount;
    }
    public User( String username,String userfacepath, String useraccnum, String userpass) {
        this.username = username;
        this.userfacepath = userfacepath;
        this.useraccnum = useraccnum;
        this.userpass = userpass;
    }

    public User(String username, String useraccnum, String userpass) {
        this.username = username;
        this.useraccnum = useraccnum;
        this.userpass = userpass;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserfacepath() {
        return userfacepath;
    }

    public void setUserfacepath(String userfacepath) {
        this.userfacepath = userfacepath;
    }

    public String getUseraccnum() {
        return useraccnum;
    }

    public void setUseraccnum(String useraccnum) {
        this.useraccnum = useraccnum;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public int getUpid() {
        return upid;
    }

    public void setUpid(int upid) {
        this.upid = upid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getIsregister() {
        return isregister;
    }

    public void setIsregister(int isregister) {
        this.isregister = isregister;
    }

    public int getFancount() {
        return fancount;
    }

    public void setFancount(int fancount) {
        this.fancount = fancount;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", useraccnum='" + useraccnum + '\'' +
                ", userfacepath='" + userfacepath + '\'' +
                ", userpass='" + userpass + '\'' +
                ", upid=" + upid +
                ", cid=" + cid +
                ", isregister=" + isregister +
                ", fancount=" + fancount +
                '}';
    }
}
