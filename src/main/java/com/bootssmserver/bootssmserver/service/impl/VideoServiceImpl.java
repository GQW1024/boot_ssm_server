package com.bootssmserver.bootssmserver.service.impl;

import com.bootssmserver.bootssmserver.dao.VideoMapper;
import com.bootssmserver.bootssmserver.entity.User;
import com.bootssmserver.bootssmserver.entity.Video;
import com.bootssmserver.bootssmserver.entity.VideoType;
import com.bootssmserver.bootssmserver.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional //为这个类开启事务处理，前提：@EnableTransactionManagement
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;


    @Override
    public int PutVideo(Video video) {
        return videoMapper.insertVideo(video);
    }

    @Override
    public List<Video> QueryAllVideoByPageNum(int pagenum) {
        return videoMapper.SelectAllVideoByNum(pagenum);
    }

    @Override
    public List<Video> QueryVideoByType(String vtype) {
        return videoMapper.SelectVideoByType(vtype);
    }

    @Override
    public List<VideoType> QueryAllVideoType() {
        return videoMapper.SelectAllVideoType();
    }

    @Override
    public int AllVideoCount() {
        return videoMapper.SelectAllVideoCount();
    }

    @Override
    public Video QueryVideoByID(int vid) {
        return videoMapper.SelectVideoByID(vid);
    }

    @Override
    public User QueryUpByUpID(int upid) {//查询视频作者
        return videoMapper.SelectUpByUpID(upid);
    }

    @Override
    public List<Video> QueryVideoByName(String videoname) {
        return videoMapper.SelectVideoByName(videoname);
    }

    @Override
    public Video QueryOneVideoByName(String videoname) {
        return videoMapper.SelectOneVideoByName(videoname);
    }

    @Override
    public int UpdateVideoCount(int vid, int playcount) {
        return videoMapper.UpdateVideoPlayCount(vid,playcount);
    }

    @Override
    public int UpdateVideoActionCount(int putcount, int downcount, int collectcount, int vid) {
        return videoMapper.UpdateVideoActionCount(putcount,downcount,collectcount,vid);
    }

    @Override
    public int UpdateVideoPath(Video video) {
        return videoMapper.UpdateVideoMessage(video);
    }
}
