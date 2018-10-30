package com.jt.sso.service.impl;

import com.jt.common.vo.SysResult;
import com.jt.sso.mapper.UserMapper;
import com.jt.sso.pojo.User;
import com.jt.sso.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    /*  用户名校验 */
    @Override
    public Boolean checkUsername(String param,Integer type) {
        //根据type的值，调用不同的mapper方法，1  用户名 2 手机号   0 邮箱
        User user = new User();
        int count = 0;
       if (type == 1){
            user.setUsername(param);
            count=userMapper.selectCount(user);
       }else  if (type ==2){
            user.setPhone(param);
            count=userMapper.selectCount(user);
        }else {
            user.setEmail(param);
            count=userMapper.selectCount(user);
        }
        Boolean result =count==1? true:false;
        return result;
    }

    /*
    注册用户
     */
    @Override
    public void doRegister(User user) {
            user.setCreated(new Date());
            user.setUpdated(user.getCreated());
            //emial还没有设置，默认为手机号
            user.setEmail(user.getPhone());
            //对注册用户进行密码加密
            SimpleHash MD5soltpassword=new SimpleHash("MD5", user.getUsername(), user.getPassword(), 1024);
            user.setPassword(MD5soltpassword.toString());
            userMapper.insert(user);
    }
}
