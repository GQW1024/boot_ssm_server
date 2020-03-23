package com.bootssmserver.bootssmserver.dao;

import com.bootssmserver.bootssmserver.entity.User;
import com.bootssmserver.bootssmserver.entity.Video;
import com.bootssmserver.bootssmserver.entity.VideoType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface VideoMapper {
    public int insertVideo(Video video);
    public List<Video> SelectAllVideoByNum(@Param("pagenum")int pagenum);
    public List<Video> SelectVideoByType(@Param("vtype")String vtype);
    public List<VideoType> SelectAllVideoType();
    public int SelectAllVideoCount();
    public Video SelectVideoByID(@Param("vid") int vid);
    public User SelectUpByUpID(@Param("upid") int upid);
    public List<Video> SelectVideoByName(@Param("videoname") String videoname);
    public Video SelectOneVideoByName(@Param("videoname") String videoname);
    public int UpdateVideoPlayCount(@Param("vid") int vid,@Param("playcount") int playcount);
    public int UpdateVideoActionCount(@Param("putcount") int putcount,@Param("downcount")int downcount,@Param("collectcount")int collectcount,@Param("vid")int vid);
    public int UpdateVideoMessage(Video video);
}
