package com.jt.web.controller;

import com.jt.common.vo.SysResult;
import com.jt.web.pojo.User;
import com.jt.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("user")
public class UserController {


        @Autowired
        private UserService userService;

        @RequestMapping("doRegister")
        @ResponseBody
        public String register(User  user){

            String sysResult =userService.doRegister(user);


            return  sysResult;
        }

}
