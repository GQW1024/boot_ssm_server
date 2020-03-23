package com.bootssmserver.bootssmserver.dao;

import com.bootssmserver.bootssmserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 查询用户是否注册
     * @param useraccnum
     * @param userpass
     * @return
     */
    public User SelectUserByCodeandPass(@Param("useraccnum") String useraccnum,@Param("userpass") String userpass);
    /**
     * 查询用户名是否存在
     * @param useraccnum
     * @return
     */
    public User SelectByUseraccnum(@Param("useraccnum") String useraccnum);
    /**
     * 查询用户昵称是否存在
     * @param username
     * @return
     */
    public User SelectByUsername(@Param("username") String username);
    /**
     * 查找视频作者
     * @param upid
     * @return
     */
    public User SelectByupid(@Param("upid") int upid);
    /**
     * 向user表中注册用户
     * @param user
     * @return
     */
    public int registerUser(User user);

    /**
     * 向user表中注册用户(不带头像)
     * @param user
     * @return
     */
    public int registerUserNoFace(User user);
    /**
     * 向user表中注册用户头像
     * @param user
     * @return
     */
    public int registerUserFace(User user);

    /**
     * 更新用户状态
     * @param isRegister
     * @param uid
     * @return
     */
    public int updataisRegister(@Param("isregister") int isRegister,@Param("uid") int uid);

    public int updataUPID(@Param("upid") int upid,@Param("cid") int cid,@Param("uid") int uid);

    public int updataUserFanCount(@Param("uid") int uid, @Param("fancount") int fancount);
}
