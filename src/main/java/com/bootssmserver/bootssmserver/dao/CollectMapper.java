package com.bootssmserver.bootssmserver.dao;

import com.bootssmserver.bootssmserver.entity.Collect;
import com.bootssmserver.bootssmserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CollectMapper {
    public int insertCollect(Collect collect);
    public int DeleteCollect(@Param("cid") int cid,@Param("vid") int vid);
    public Collect SelectCollect(@Param("cid") int cid,@Param("vid") int vid);
    public int SelectCollectCount(@Param("cid") int cid);
}
