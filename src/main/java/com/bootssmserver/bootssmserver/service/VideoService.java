package com.bootssmserver.bootssmserver.service;

import com.bootssmserver.bootssmserver.entity.User;
import com.bootssmserver.bootssmserver.entity.Video;
import com.bootssmserver.bootssmserver.entity.VideoType;

import java.util.List;

public interface VideoService {
    public int PutVideo(Video video);
    public List<Video> QueryAllVideoByPageNum(int pagenum);
    public List<Video> QueryVideoByType(String vtype);
    public List<VideoType> QueryAllVideoType();
    public int AllVideoCount();
    public Video QueryVideoByID(int vid);
    public User QueryUpByUpID(int upid);
    public List<Video> QueryVideoByName(String videoname);
    public Video QueryOneVideoByName(String videoname);
    public int UpdateVideoCount(int vid,int playcount);
    public int UpdateVideoActionCount(int putcount,int downcount,int collectcount,int vid);
    public int UpdateVideoPath(Video video);

}
