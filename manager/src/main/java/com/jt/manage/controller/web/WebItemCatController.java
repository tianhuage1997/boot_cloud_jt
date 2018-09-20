package com.jt.manage.controller.web;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.manage.pojo.ItemCatResult;
import com.jt.manage.service.WebItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebItemCatController {

    @Autowired
    private WebItemCatService webItemCatService;

    @RequestMapping("web/itemcat/all")
    @ResponseBody
    public JSONPObject queryItemCatAll(String callback){
        ItemCatResult result=webItemCatService.queryItemCatAll();
        JSONPObject resultJsonp=new JSONPObject(callback,result);
        return  resultJsonp;
    }
}
