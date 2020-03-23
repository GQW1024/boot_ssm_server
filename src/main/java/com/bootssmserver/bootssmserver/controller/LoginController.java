package com.bootssmserver.bootssmserver.controller;

import com.bootssmserver.bootssmserver.entity.User;
import com.bootssmserver.bootssmserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"usermessage"}) //Model中key=user的数据也会存到HttpSession
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping("doLogin")//登录
    public ModelAndView doLogin(@RequestParam("useraccnum")String useraccnum, @RequestParam("userpass")String userpass, ModelAndView modelAndView){
        User user = userService.isUserEmpty(useraccnum,userpass);
        if (user!=null) {
            userService.updateisRegister(1,user.getUid());
            user.setIsregister(1);//设置状态为已登录
            modelAndView.addObject("usermessage",user);
            modelAndView.setViewName("index");
            System.out.println(user.getUid()+","+user.getUseraccnum()+" , "+user.getUsername()+" , "+user.getUserpass());
        }else{
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }
    @RequestMapping("doLoginOut")//登出
    public String doLogin(@RequestParam("uid")int uid, HttpSession session,SessionStatus sessionStatus){
            userService.updateisRegister(0,uid);//将用户设为下线
            session.removeAttribute("usermessage");
            session.invalidate();//无效化session删除这次的用户会话信息
            sessionStatus.setComplete();
        return "index";
    }
    @RequestMapping("selUseraccnum")//查找用户账号
    @ResponseBody
    public Boolean selUseraccnum(@RequestParam(value = "useraccnum",required = false)String useraccnum){
        User user = userService.SelectUseraccnum(useraccnum);
        if (!useraccnum.isEmpty()||user!=null) {
            return true;
        }else{
            return false;
        }
    }

}
