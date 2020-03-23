package com.bootssmserver.bootssmserver.dao;

import com.bootssmserver.bootssmserver.entity.User_up;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface User_upMapper {
    public User_up SelectisFollow(@Param("uid") int uid, @Param("upid") int upid);//查询是否关注
    public int SelectFollowCount(@Param("uid") int uid);//查询是否关注
    public int InsertDefaultFollowMessage(User_up user_up);//查询是否关注
    public int UpdateisFollow(@Param("uid") int uid, @Param("upid") int upid,@Param("isfollow") int isfollow);//修改关注状态
}
