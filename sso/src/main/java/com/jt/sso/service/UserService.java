package com.jt.sso.service;


import com.jt.common.vo.SysResult;
import com.jt.sso.pojo.User;

import java.util.HashMap;

public interface UserService {

    Boolean checkUsername(String param,Integer type);

    void doRegister(User user);

    String doLogin(String u, String p);

    String findUserByTicketKey(String ticket);
}
