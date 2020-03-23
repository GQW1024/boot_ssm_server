package com.bootssmserver.bootssmserver.dao;

import com.bootssmserver.bootssmserver.entity.User_up;
import com.bootssmserver.bootssmserver.entity.Useraction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository//用户对视频操作
public interface UseractionMapper {
    public Useraction SelectUserAction(@Param("uid") int uid, @Param("vid") int vid);//查询是否关注
    public int InsertDefaultUseractionMessage(Useraction useraction);//查询是否关注
    public int UpdateUseraction(Useraction useraction);//修改关注状态
}
