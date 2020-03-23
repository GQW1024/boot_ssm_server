package com.bootssmserver.bootssmserver.service;

import com.bootssmserver.bootssmserver.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    public User isUserEmpty(String useraccnum,String userpass);
    public User SelectUseraccnum(String useraccnum);//查帐号
    public User SelectUsername(String username);//查昵称
    public User SelectUserByUpid(int upid);//查昵称
    public int doRegisterUser(User user);
    public int updateisRegister(int isregister,int uid);
    public int updataID(int upid,int cid,int uid);
    public int doRegisterUserNoFace(User user);
    public int doRegisterUserFace(User user);
    public int UpdateFanCount(@Param("uid") int uid, @Param("fancount") int fancount);

}
