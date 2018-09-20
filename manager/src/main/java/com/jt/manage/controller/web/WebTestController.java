package com.jt.manage.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebTestController {


    @RequestMapping("hi")
    @ResponseBody
    public  String  hello(String  itemId){
        System.out.println("接受前端传过来的:"+itemId);
        return  "我是后台的"+itemId;
    }
}
