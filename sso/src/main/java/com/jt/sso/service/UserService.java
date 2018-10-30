package com.jt.sso.service;


import com.jt.sso.pojo.User;

public interface UserService {

    Boolean checkUsername(String param,Integer type);

    void doRegister(User user);
}
