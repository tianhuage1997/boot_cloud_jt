package com.jt.web.controller;


import com.jt.web.pojo.Item;
import com.jt.web.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class ItemController {

        @Autowired
        private ItemService itemService;

        @RequestMapping("items/{itemId}")
        public   String queryItem(@PathVariable  String itemId, Model model) throws Exception {
                System.out.println("itemId:"+itemId);
                Item item = itemService.queryItemByitemId(itemId);
                model.addAttribute("item",item);
                return  "item";
        }


}
