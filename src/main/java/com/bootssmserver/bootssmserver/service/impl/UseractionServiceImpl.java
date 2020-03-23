package com.bootssmserver.bootssmserver.service.impl;

import com.bootssmserver.bootssmserver.dao.UserMapper;
import com.bootssmserver.bootssmserver.dao.UseractionMapper;
import com.bootssmserver.bootssmserver.entity.User;
import com.bootssmserver.bootssmserver.entity.Useraction;
import com.bootssmserver.bootssmserver.service.UserService;
import com.bootssmserver.bootssmserver.service.UseractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional //为这个类开启事务处理，前提：@EnableTransactionManagement
@Service
public class UseractionServiceImpl implements UseractionService {
    @Autowired
    UseractionMapper useractionMapper;


    @Override
    public Useraction SelectsThisUserAction(int uid, int vid) {
        return useractionMapper.SelectUserAction(uid,vid);
    }

    @Override
    public int InsertUseraction(Useraction useraction) {
        return useractionMapper.InsertDefaultUseractionMessage(useraction);
    }

    @Override
    public int updateUseraction(Useraction useraction) {
        return useractionMapper.UpdateUseraction(useraction);
    }
}
