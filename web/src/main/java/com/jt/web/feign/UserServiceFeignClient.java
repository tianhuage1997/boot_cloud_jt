package com.jt.web.feign;


import com.jt.common.vo.SysResult;
import com.jt.web.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "server-sso")
public interface UserServiceFeignClient {


    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    String  doRegiste(@RequestBody User user);


}
