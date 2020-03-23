package com.bootssmserver.bootssmserver.controller;

import com.bootssmserver.bootssmserver.entity.User;
import com.bootssmserver.bootssmserver.service.CollectService;
import com.bootssmserver.bootssmserver.service.User_upService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class indexController {
    @Autowired
    User_upService user_upService;

    @Autowired
    CollectService collectService;

    @RequestMapping("index")//前往登录页
    public String toindex(){
        return "index";
    }

    @RequestMapping("indexagain")//ajax测试
    //@ResponseBody //代表返回JSON字符串
    public ModelAndView toindexagain(String test , ModelAndView modelAndView){
        return modelAndView;
    }
    @RequestMapping("tovideoPlayer")//前往登录页
    public ModelAndView tovideoPlayer(@RequestParam(value = "videopath",required = false)String vidopath,ModelAndView modelAndView){
        System.out.println(vidopath);
        modelAndView.setViewName("videoPlayer");
        modelAndView.addObject("videopath",vidopath);
        return modelAndView;
    }
    @RequestMapping("tologin")//前往登录页
    public String tologin(){
        System.out.println("..........login..........");
        return "login";
    }
    @RequestMapping("toregister")//前往注册页
    public String toregister(){
        System.out.println("..........register..........");
        return "register";
    }
    @RequestMapping("toUserpage")//前往用户页
    public ModelAndView toUserpage(@RequestParam("uid")int uid , ModelAndView modelAndView){
        modelAndView.addObject("followcount",user_upService.QueryFollowCount(uid));
        modelAndView.addObject("collectcount",collectService.selCollectCount(uid));
        modelAndView.setViewName("Userpage");
        return modelAndView;
    }


}
