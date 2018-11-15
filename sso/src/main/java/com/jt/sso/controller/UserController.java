package com.jt.sso.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.common.vo.SysResult;
import com.jt.sso.pojo.User;
import com.jt.sso.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;


@Controller
@RequestMapping("user")
public class UserController {

        @Autowired
        private UserService userService;

        private final static ObjectMapper objectMapper=new ObjectMapper();

        /*
        检查用户名是否已经存在，有callback回调函数的
         */
        @RequestMapping("/check/{param}/{type}")
        @ResponseBody
       public JSONPObject doCheckUsername(@PathVariable  String param,@PathVariable Integer type,String callback){

            Boolean  exists = userService.checkUsername(param,type);

            JSONPObject resultJsonp=new JSONPObject(callback,SysResult.oK(exists));

            return  resultJsonp;
       }


       /*
       注册用户
        */
       @RequestMapping(value = "register",method = RequestMethod.POST)
       @ResponseBody
       public  SysResult doRegister(@RequestBody User user  ){
           System.err.println("进入sso的注册"+user.getUsername());

           try {
               userService.doRegister(user);
               return  SysResult.oK(user.getUsername());
           }catch (Exception e){
               e.printStackTrace();
               return  SysResult.build(201,"注册失败");
           }

       }

       @RequestMapping(value = "login",method = RequestMethod.POST)
       @ResponseBody
       public String doLogin(String u, String p) throws JsonProcessingException {
           System.out.println("我进来了");
           String   ticketJSON =userService.doLogin(u,p);
          // String JSON=objectMapper.writeValueAsString(map);

         return  ticketJSON;

       }
        //http://sso.jt.com/user/query/" + _ticket
       @RequestMapping("query/{ticket}")
       @ResponseBody
       public  Object findUserByTicketKey(@PathVariable String ticket,String callback){
           //从redis中获取数据
           System.out.println("sso的ticket数据："+ticket);
           String UserJSON=userService.findUserByTicketKey(ticket);
           if (StringUtils.isEmpty(UserJSON)){
               return SysResult.build(201,"根据tiket没有查询到用户信息");
           }else {
               SysResult sysResult =SysResult.oK(UserJSON);
               MappingJacksonValue jacksonValue=new MappingJacksonValue(sysResult);
               jacksonValue.setJsonpFunction(callback);
               return  jacksonValue;
           }

       }
}
