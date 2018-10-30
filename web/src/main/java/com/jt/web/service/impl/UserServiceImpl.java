package com.jt.web.service.impl;

import com.jt.common.vo.SysResult;
import com.jt.web.feign.UserServiceFeignClient;
import com.jt.web.pojo.User;
import com.jt.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    @Override
    public String doRegister(User user) {
        System.out.println("进入前端的sso注册");
        String sysResult=userServiceFeignClient.doRegiste(user);

        return sysResult;
    }
}
