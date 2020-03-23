package com.bootssmserver.bootssmserver.controller;

import com.bootssmserver.bootssmserver.entity.*;
import com.bootssmserver.bootssmserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class VideoController {

    @Autowired
    VideoService videoService;//视频相关业务

    @Autowired
    UserService userService;//用户相关业务

    @Autowired
    User_upService user_upService;//用户与up主关系业务

    @Autowired
    UseractionService useractionService;//用户对视频操作业务

    @Autowired
    CollectService collectService;//用户收藏夹相关业务

    @RequestMapping("loadVideoByPagenum")//主页分页
    @ResponseBody
    public List<Video> loadVideo(@RequestParam(value = "pagenum",required = false,defaultValue = "0") int page){
        if(page!=0) {
            page = page * 12 - 12;
        }
        List<Video> videoList = videoService.QueryAllVideoByPageNum(page);
        return videoList;
    }
    @RequestMapping("videoCount")
    @ResponseBody
    public int videoCount(){
        int count = videoService.AllVideoCount();
        System.out.println(count);
        return count;
    }
    @RequestMapping("loadVideoByType")//视频页面的相关视频
    @ResponseBody
    public List<Object> loadVideoByType(@RequestParam(value = "vtype",required = false)String vtype){
        List<Video> videoList = videoService.QueryVideoByType(vtype);//byType
        List<User> userList=new ArrayList<User>();
        for(int i=0;i<videoList.size();i++){//查询相关视频的作者
            User vcreater = userService.SelectUserByUpid(videoList.get(i).getUpid());
            userList.add(vcreater);
        }
        List<Object> list = new ArrayList<Object>();
        list.add(videoList);
        list.add(userList);
        System.out.println("相关视频信息查询完毕");
        return list;
    }

    @RequestMapping("loadVideoByVid")//加载单个视频
    public ModelAndView loadVideoByVid(@RequestParam(value = "vid",required = false)int vid,@RequestParam(value = "uid",required = false)int uid,ModelAndView modelAndView){
        Video video = videoService.QueryVideoByID(vid);
        int playcount = video.getPlaycount()+1;
        int isupdate = videoService.UpdateVideoCount(vid,playcount);//播放量加1
        User videocreater = userService.SelectUserByUpid(video.getUpid());
        User_up isfollow = new User_up(uid,video.getUpid(),0,0);//用户与up的默认关系
        Useraction useraction = new Useraction();//用户对于该视屏的默认操作操作
        if(uid!=0) {//如果是已经正常登录的用户
            isfollow = user_upService.SelectFollowMessage(uid, video.getUpid());
            useraction = useractionService.SelectsThisUserAction(uid,vid);
            if (isfollow == null) {//如果用户和up是第一次见，则将默认关系信息录入数据库user_up表
                user_upService.doInsertFolloeMessage(new User_up(uid, video.getUpid()));
                isfollow = user_upService.SelectFollowMessage(uid, video.getUpid());//是否关注信息
            }
            if(useraction == null){//如果用户没有看过该视频，则将默认操作录入数据表
                useraction = new Useraction(vid,uid,0,0,0);
                useractionService.InsertUseraction(useraction);
                useraction = useractionService.SelectsThisUserAction(uid,vid);
            }
        }
        modelAndView.addObject("video",video);//视频信息
        modelAndView.addObject("videocreater",videocreater);//up主信息
        modelAndView.addObject("followmessage",isfollow);//用户与up主
        modelAndView.addObject("useraction",useraction);//用户与视频
        modelAndView.addObject("videodis","videodiss");//加载视频评论,建议ajax实现！！！
       modelAndView.setViewName("videoPlayer");
        return modelAndView;
    }
    @RequestMapping("serarch")//查询特定视频
    public ModelAndView serarch(@RequestParam(value = "SMessage",required = false)String SMessage, ModelAndView modelAndView){
        List<Video> videoList = videoService.QueryVideoByName(SMessage);

        modelAndView.addObject("keyword",SMessage);
        modelAndView.addObject("vidoelist",videoList);
        modelAndView.setViewName("SelectPage");
        System.out.println("查询关键字"+SMessage);
        return modelAndView;
    }
    @RequestMapping("updateisFollow")//修改关注状态
    @ResponseBody
    public String updateisFollow(@RequestParam(value = "uid",required = false)int uid,@RequestParam(value = "upid",required = false)int upid,@RequestParam(value = "isFollow",required = false)int isfollow){
        int issuccess;
        User user = videoService.QueryUpByUpID(upid);//查询视频作者
        if(isfollow==1){
            int count = userService.UpdateFanCount(upid,user.getFancount()+1);
            issuccess = user_upService.UpdateUser_upisFollow(uid,upid,isfollow);
            System.out.println(issuccess+","+count);
        }else if(isfollow==0){
            int count = userService.UpdateFanCount(upid,user.getFancount()-1);
            issuccess = user_upService.UpdateUser_upisFollow(uid,upid,isfollow);
            System.out.println(issuccess+","+count);
        }
        return "修改关注状态成功";
    }
    @RequestMapping("loadUserActionforThisVideo")//加载用户对视频的操作
    @ResponseBody
    public Useraction loadUserActionforThisVideo(@RequestParam(value = "uid",required = false)int uid, @RequestParam(value = "vid",required = false)int vid){
        int issuccess;//修改操作成功与否
        Useraction useraction = new Useraction(vid,uid,0,0,0);
        User user = userService.SelectUserByUpid(uid);//查询用户信息
        if(user!=null) {//用户对于视频的操作，以及收藏夹的一些操作
            useraction = useractionService.SelectsThisUserAction(uid, vid);
        }
        return useraction;
    }
    @RequestMapping("updateUseraction")//进行用户的一系列操作
    @ResponseBody
    public Video ForUserAction(@RequestParam(value = "uid",required = false)int uid, @RequestParam(value = "vid",required = false)int vid,@RequestParam(value = "isup",required = false)int isup, @RequestParam(value = "isdown",required = false)int isdown,@RequestParam(value = "iscollect",required = false)int iscollect){
        if (uid>0) {//如果用户已登录
            System.out.println("已接收用户反馈");
            Useraction useraction = useractionService.SelectsThisUserAction(uid,vid);//当前用户对当前视频所做的 操作
            Video video = videoService.QueryVideoByID(vid);//当前视频
            User videocreater = userService.SelectUserByUpid(video.getUpid());//当前视频作者
            User user = userService.SelectUserByUpid(uid);//当前用户
             if(isup==1){
                videoService.UpdateVideoActionCount(video.getPutcount()+1,video.getDowncount(),video.getCollectcount(),vid);
                useraction.setUp(1);//标记点赞操作
                useractionService.updateUseraction(useraction);
             }else if(isup==0){
                 videoService.UpdateVideoActionCount(video.getPutcount()-1,video.getDowncount(),video.getCollectcount(),vid);
                 useraction.setUp(0);
                 useractionService.updateUseraction(useraction);
             }
             if(isdown==1){
                videoService.UpdateVideoActionCount(video.getPutcount(),video.getDowncount()+1,video.getCollectcount(),vid);
                useraction.setDown(1);//标记踩操作
                useractionService.updateUseraction(useraction);
             }else if(isdown==0){
                 videoService.UpdateVideoActionCount(video.getPutcount(),video.getDowncount()-1,video.getCollectcount(),vid);
                 useraction.setDown(0);
                 useractionService.updateUseraction(useraction);
             }
            if(iscollect==1){
                Collect collect = collectService.selCollect(user.getCid(),vid);
                if(collect == null) {//如果没有，则收藏
                    collect = new Collect(user.getCid(), vid, video.getVideoname(), video.getVideopath(), videocreater.getUsername());//生成要收藏的视频信息
                    collectService.insCollect(collect);
                    videoService.UpdateVideoActionCount(video.getPutcount(),video.getDowncount(),video.getCollectcount()+1,vid);
                }
                useraction.setCollect(1);//标记用户收藏操作
                useractionService.updateUseraction(useraction);
            }else if(iscollect==0){
                Collect collect = collectService.selCollect(user.getCid(),vid);
                if(collect != null) {//如果有，则取消收藏
                    collectService.delCollect(user.getCid(),vid);
                    videoService.UpdateVideoActionCount(video.getPutcount(),video.getDowncount(),video.getCollectcount()-1,vid);
                }
                useraction.setCollect(0);//标记用户取消收藏操作
                useractionService.updateUseraction(useraction);
            }
            }
        return videoService.QueryVideoByID(vid);//返回当前视频信息
    }
    @RequestMapping("loadAllVideoType")//加载所有视频类型
    @ResponseBody
    public List<VideoType> loadAllVideoType(){
        List<VideoType> videoTypes =  videoService.QueryAllVideoType();
        return videoTypes;
    }
    @RequestMapping("uploadVideo")//录入所有视频信息 doUploadVideo
    public String uploadVideo(@RequestParam("videoname")String videoname, @RequestParam("videotype")String videotype, @RequestParam("videoabstract")String videoabstract, @RequestParam("videoface") MultipartFile videoface, @RequestParam("video")MultipartFile video, @RequestParam("userid")int userid) throws ParseException {//videoname videotype videoabstract videoface video userid
        int num=0;
        if(userid>0){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            Video videoMessage = new Video(userid,videoname,videotype,videoabstract,0,0,0,0,df.parse(df.format(new Date())));
            num = videoService.PutVideo(videoMessage);
        }
        if (num > 0) {
            return "forward:doUploadVideo";
        }else {
            return "forward:toupload";
        }
    }
}
