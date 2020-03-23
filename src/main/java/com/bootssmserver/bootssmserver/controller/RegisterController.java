package com.bootssmserver.bootssmserver.controller;

import com.bootssmserver.bootssmserver.entity.IP;
import com.bootssmserver.bootssmserver.entity.User;
import com.bootssmserver.bootssmserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;
    @Autowired
    IP ip;

    @RequestMapping("doregister")
    private String doregister(@RequestParam(value = "username",required = false)String username,
                              @RequestParam(value = "userface",required = false) MultipartFile userface,
                              @RequestParam(value = "useraccnum",required = false)String useraccnum,
                              @RequestParam(value = "userpass",required = false)String userpass,
                              @RequestParam(value = "userpass2",required = false)String userpass2,
                              @RequestParam(value = "uploadType",required = false)String uploadtype
                              ) {
        //当用户确定头像时
        if (!username.isEmpty() && !userface.isEmpty() && !useraccnum.isEmpty() && !userpass.isEmpty() && !userpass2.isEmpty()&& userpass.equals(userpass2)) {
            String userfacepath = "http://" + ip.getIP() + ":8080/uploadfile/Userface/" + userface.getOriginalFilename();//http://localhost:8080/uploadfile/Userface/JoTaRo.jpeg

            int count = userService.doRegisterUser(new User(username, userfacepath, useraccnum, userpass));
            if (count == 1) {
                User user = userService.SelectUsername(username);
                userService.updataID(user.getUid(),user.getUid(),user.getUid());
                System.out.println("注册成功1"+user.getUid());
            } else {
                System.out.println("注册失败");
                return "register";
            }
            return "forward:uploadUserMessage";//上传头像
        }
        else if (!username.isEmpty() && userface.isEmpty() && !useraccnum.isEmpty() && !userpass.isEmpty() && !userpass2.isEmpty() && userpass.equals(userpass2)) {
            int count = userService.doRegisterUserNoFace(new User(username, useraccnum, userpass));
            if (count == 1) {
                User user = userService.SelectUsername(username);
                userService.updataID(user.getUid(),user.getUid(),user.getUid());//统一各部分id
                System.out.println("注册成功2"+user.getUid());
                return "forward:doLogin?useraccnum="+useraccnum+"&userpass="+userpass;//注册成功直接登录
            } else {
                System.out.println("注册失败");
                return "register";
            }

        }
        else {
            System.out.println("注册失败");
            return "register";//如果注册失败，则跳回注册页
        }

    }
    @RequestMapping("selUsername")//查找用户昵称是否重名
    @ResponseBody
    public Boolean selUseraccnum(@RequestParam(value = "username",required = false)String username){
        User user = userService.SelectUsername(username);
        if (username.isEmpty()||user!=null) {
            return true;
        }else{
            return false;
        }
    }
}
