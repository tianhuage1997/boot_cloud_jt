package com.jt.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.util.CookieUtils;
import com.jt.common.vo.SysResult;
import com.jt.web.feign.UserServiceFeignClient;
import com.jt.web.pojo.User;
import com.jt.web.service.UserService;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    private final static ObjectMapper  objectMapper =new ObjectMapper();

    @Override
    public String doRegister(User user) {
        String sysResult=userServiceFeignClient.doRegiste(user);

        return sysResult;
    }

    @Override
    public SysResult doLogin(String username, String password,HttpServletRequest request, HttpServletResponse response) throws IOException {

        String ticket =userServiceFeignClient.doLogin(username,password);
        System.out.println("web的sso的ticket:"+ticket);

        if (!StringUtils.isEmpty(ticket)){
            //如果key的长度小于2，那么key就是ticket的数据
            //讲ticket存储到cookie
           CookieUtils.setCookie(request,response,"JT_TICKET",ticket,true);
           return SysResult.oK();

        }
        return SysResult.build(201,"登录失败");
    }
}
