package com.jt.sso.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.util.CookieUtils;
import com.jt.common.vo.SysResult;
import com.jt.sso.mapper.UserMapper;
import com.jt.sso.pojo.User;
import com.jt.sso.redis.RedisService;
import com.jt.sso.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.Date;
import java.util.HashMap;

@Service
public class UserServiceImpl  implements UserService {

    private  static ObjectMapper objectMapper=new ObjectMapper();

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

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
        System.out.println("注册的MD5加密数值:"+MD5soltpassword.toString());
            userMapper.insert(user);
    }

    /*
    用户名密码比对
    key 为ticket ：成功
    key 为1： 失败
     */
    @Override
    public String doLogin(String u, String p) {

        //设置参数
        User user_arg =new User();
        user_arg.setUsername(u);

        User userCheck=userMapper.selectOne(user_arg);
        if (userCheck!=null){
             //查到了结果
            //判断密码是否相同
            SimpleHash  MD5soltpassword=new SimpleHash("MD5",u,p,1024);
            System.out.println("MD5soltpassword:"+MD5soltpassword.toString());
            System.out.println("userCheck.getPassword()"+userCheck.getPassword());
            if (userCheck.getPassword().equals(MD5soltpassword.toString())){
               //计算ticket
                String ticket= DigestUtils.md5Hex("JT_TICKET"+System.currentTimeMillis()+u);

                //将user存储到redis
                try {
                    String UserJSON=objectMapper.writeValueAsString(userCheck);
                    redisService.set(ticket,UserJSON);
                    return  ticket;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
        //如果以上两个if都没有满足，那么就是登录失败。

        return "";
    }

    @Override
    public String findUserByTicketKey(String ticket) {
        String UserTicket=redisService.get(ticket);
        if (StringUtils.isEmpty(UserTicket)){
             return  null;
        }else {

            return UserTicket;
        }

    }
}
