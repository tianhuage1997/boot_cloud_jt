package com.jt.sso.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.common.vo.SysResult;
import com.jt.sso.pojo.User;
import com.jt.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@Controller
@RequestMapping("user")
public class UserController {

        @Autowired
        private UserService userService;

        /*
        检查用户名是否已经存在，有callback回调函数的
         */
        @RequestMapping("/check/{param}/{type}")
        @ResponseBody
       public JSONPObject doCheckUsername(@PathVariable  String param,@PathVariable Integer type,String callback){

            Boolean  exists = userService.checkUsername(param,type);

            JSONPObject resultJsonp=new JSONPObject(callback,SysResult.oK(exists));

            return  resultJsonp;
       }

       /*
       注册用户
        */
       @RequestMapping(value = "register",method = RequestMethod.POST)
       @ResponseBody
       public  SysResult doRegister(@RequestBody User user  ){
           System.err.println("进入sso的注册"+user.getUsername());

           try {
               userService.doRegister(user);
               return  SysResult.oK(user.getUsername());
           }catch (Exception e){
               e.printStackTrace();
               return  SysResult.build(201,"注册失败");
           }

       }
}
