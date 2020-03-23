package com.bootssmserver.bootssmserver.controller;

import com.bootssmserver.bootssmserver.entity.IP;
import com.bootssmserver.bootssmserver.entity.Video;
import com.bootssmserver.bootssmserver.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    @Autowired
    VideoService videoService;
    @Autowired
    IP ip;

    @Value("${web.upload-path}")
    private String filePath;

    @RequestMapping("toupload")
    public String toupload() {
        return "uploadvideo";
    }

    @PostMapping("uploadUserMessage")
    public ModelAndView upload(@RequestParam("userface") MultipartFile file,@RequestParam("uploadType")String uploadType , ModelAndView modelAndView) {//file：需要上传的文件
        if (file.isEmpty()) {
            modelAndView.addObject("uploadMessage","上传失败，请选择文件");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        String fileName = file.getOriginalFilename();


        if(uploadType.equals("USERFACE")) {
            filePath = filePath+"Userface/";
        }
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            modelAndView.addObject("uploadMessage","上传成功");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        modelAndView.addObject("uploadMessage","上传失败，请选择文件");
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @PostMapping("doUploadVideo")
    public ModelAndView doUploadVideo(@RequestParam("videoface") MultipartFile videoface,@RequestParam("video")MultipartFile video , @RequestParam("videoname") String videoname, ModelAndView modelAndView) {//file：需要上传的文件
        if (videoface.isEmpty()&&video.isEmpty()) {
            modelAndView.addObject("uploadMessage","上传失败，请选择全部文件");
            modelAndView.setViewName("forward:toupload");
            return modelAndView;
        }

        String videofacepath = new String(filePath+"Videoface/");//两个文件的存储路径
        String videopath = new String(filePath+"Video/");

        String videofacefileName = videoface.getOriginalFilename();//两个文件的文件名
        String videofileName = video.getOriginalFilename();

        File videofacefile = new File(videofacepath + videofacefileName);//缓存文件
        File videofile = new File(videopath + videofileName);
        try {
            videoface.transferTo(videofacefile);
            video.transferTo(videofile);
            LOGGER.info("上传成功");
            //两个文件的映射路径
            String fakevideofacepath = "http://" + ip.getIP() + ":8080/uploadfile/Videoface/" + videoface.getOriginalFilename();
            String fakevideopath = "http://" + ip.getIP() + ":8080/uploadfile/Video/" + video.getOriginalFilename();
            Video thisVideoMessage = videoService.QueryOneVideoByName(videoname);
            int num = videoService.UpdateVideoPath(new Video(thisVideoMessage.getVid(),thisVideoMessage.getVid(),fakevideofacepath,fakevideopath));
            modelAndView.addObject("uploadMessage","上传传视频成功："+num);
            modelAndView.setViewName("forward:toupload");
            return modelAndView;
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        modelAndView.addObject("uploadMessage","上传失败，请选择正确MP4文件");
        modelAndView.setViewName("forward:toupload");
        return modelAndView;
    }
}
