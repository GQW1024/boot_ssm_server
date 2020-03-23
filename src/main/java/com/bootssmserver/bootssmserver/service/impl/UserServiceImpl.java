package com.bootssmserver.bootssmserver.service.impl;

import com.bootssmserver.bootssmserver.dao.UserMapper;
import com.bootssmserver.bootssmserver.entity.User;
import com.bootssmserver.bootssmserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional //为这个类开启事务处理，前提：@EnableTransactionManagement
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User isUserEmpty(String useraccnum,String userpass) {
        return userMapper.SelectUserByCodeandPass(useraccnum,userpass);
    }

    @Override
    public User SelectUseraccnum(String useraccnum) {
        return userMapper.SelectByUseraccnum(useraccnum);
    }

    @Override
    public User SelectUsername(String username) {
        return userMapper.SelectByUsername(username);
    }

    @Override
    public User SelectUserByUpid(int upid) {
        return userMapper.SelectByupid(upid);
    }

    @Override
    public int doRegisterUser(User user) {
        return userMapper.registerUser(user);
    }

    @Override
    public int updateisRegister(int isregister, int uid) {
        return userMapper.updataisRegister(isregister,uid);
    }

    @Override
    public int updataID(int upid,int cid,int uid) {
        return userMapper.updataUPID(upid,cid,uid);
    }

    @Override
    public int doRegisterUserNoFace(User user) {
        return userMapper.registerUserNoFace(user);
    }

    @Override
    public int doRegisterUserFace(User user) {
        return userMapper.registerUserFace(user);
    }

    @Override
    public int UpdateFanCount(int uid, int fancount) {
        return userMapper.updataUserFanCount(uid,fancount);
    }

}
