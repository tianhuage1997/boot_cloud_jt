package com.jt.sso.service.impl;

import com.jt.common.vo.SysResult;
import com.jt.sso.mapper.UserMapper;
import com.jt.sso.pojo.User;
import com.jt.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
