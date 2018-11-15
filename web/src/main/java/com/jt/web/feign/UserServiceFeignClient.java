package com.jt.web.feign;


import com.jt.common.vo.SysResult;
import com.jt.web.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@FeignClient(value = "server-sso")
public interface UserServiceFeignClient {


    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    String  doRegiste(@RequestBody User user);

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    String doLogin(@RequestParam(value = "u")  String username, @RequestParam(value = "p")  String  password);

}
