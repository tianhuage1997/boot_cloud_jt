package com.jt.sso.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.common.vo.SysResult;
import com.jt.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

        @Autowired
        private UserService userService;

        /*
        检查用户名是否已经存在，有callback回调函数的
         */
        @RequestMapping("check/{param}/{type}")
       public JSONPObject doCheckUsername(@PathVariable  String param,@PathVariable Integer type,String callback){

            Boolean  exists = userService.checkUsername(param,type);

            JSONPObject resultJsonp=new JSONPObject(callback,SysResult.oK(exists));

            return  resultJsonp;
       }
}
