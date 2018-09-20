package com.jt.web.controller;


import com.jt.web.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

        @Autowired
        private ItemService itemService;

        @RequestMapping("items/{itemId}")
        @ResponseBody
        public   String queryItem(@PathVariable  String itemId){

            return  "";
        }


}
