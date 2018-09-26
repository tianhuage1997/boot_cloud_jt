package com.jt.manage.controller;




import com.jt.manage.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class RedisTestController {


       @Autowired
       private RedisService redisService;



       @RequestMapping("/zzk1")
        @ResponseBody
       public String redisUrlTest(){
              System.err.println("进来了进来了");
            String name = "zzk3";
            redisService.set(name,name+"你个鸡腿");
            String result = redisService.get(name);
            return  result;

       }

}
