package com.jt.web.controller;

import com.jt.common.util.CookieUtils;
import com.jt.common.vo.SysResult;
import com.jt.web.pojo.User;
import com.jt.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {


        @Autowired
        private UserService userService;

        /*
        注册功能
         */
        @RequestMapping("doRegister")
        @ResponseBody
        public String register(User  user){

            String sysResult =userService.doRegister(user);


            return  sysResult;
        }


        /*
        登录功能
         */
        @RequestMapping("doLogin")
        @ResponseBody
        public  SysResult  doLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
            System.err.println("username:"+username+",password:"+password);
            System.err.println("ckkoie数据:"+CookieUtils.getCookieValue(request,"JT_TICKET"));
            SysResult  sysResult =userService.doLogin(username,password,request,response);
            System.out.println("前端设置完成");
            return   sysResult;
        }


        /*
       http://www.jt.com/user/logout.html
         */
        @RequestMapping("logout")
        public  String  doLogout(HttpServletRequest request,HttpServletResponse response){
            CookieUtils.deleteCookie(request,response,"JT_TICKET");
            return  "index";
        }
}
