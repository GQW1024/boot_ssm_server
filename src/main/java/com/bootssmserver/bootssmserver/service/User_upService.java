package com.bootssmserver.bootssmserver.service;

import com.bootssmserver.bootssmserver.entity.User;
import com.bootssmserver.bootssmserver.entity.User_up;

public interface User_upService {
    public User_up SelectFollowMessage(int uid,int upid);//查询关注信息
    public int QueryFollowCount(int uid);//查询关注数量
    public int doInsertFolloeMessage(User_up user_up);//录入默认信息
    public int UpdateUser_upisFollow(int uid,int upid,int isfollow);//录入默认信息
}
