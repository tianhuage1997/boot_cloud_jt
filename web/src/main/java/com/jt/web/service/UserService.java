package com.jt.web.service;

import com.jt.common.vo.SysResult;
import com.jt.web.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UserService {

   String  doRegister(User user);

   SysResult  doLogin(String username, String password,HttpServletRequest request, HttpServletResponse response) throws IOException;
}
