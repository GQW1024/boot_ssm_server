package com.bootssmserver.bootssmserver.service.impl;

import com.bootssmserver.bootssmserver.dao.User_upMapper;
import com.bootssmserver.bootssmserver.entity.User_up;
import com.bootssmserver.bootssmserver.service.User_upService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional //为这个类开启事务处理，前提：@EnableTransactionManagement
@Service
public class User_upServiceImpl implements User_upService {
    @Autowired
    User_upMapper user_upMapper;
    @Override
    public User_up SelectFollowMessage(int uid, int upid) {
        return user_upMapper.SelectisFollow(uid,upid);
    }

    @Override
    public int QueryFollowCount(int uid) {
        return user_upMapper.SelectFollowCount(uid);
    }

    @Override
    public int doInsertFolloeMessage(User_up user_up) {
        return user_upMapper.InsertDefaultFollowMessage(user_up);
    }

    @Override
    public int UpdateUser_upisFollow(int uid, int upid, int isfollow) {
        return user_upMapper.UpdateisFollow(uid,upid,isfollow);
    }
}
