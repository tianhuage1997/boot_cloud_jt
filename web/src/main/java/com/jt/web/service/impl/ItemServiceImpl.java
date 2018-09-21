package com.jt.web.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.web.feign.ItemServiceFeignClient;
import com.jt.web.pojo.Item;
import com.jt.web.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ItemServiceImpl  implements ItemService {

    @Autowired
    private ItemServiceFeignClient itemServiceFeignClient;


    private  static   final ObjectMapper objectMapper = new ObjectMapper();

    /*
        通过注册中心，去manager寻找对应的url，通过restful去传输数据
     */
    @Override
    public Item queryItemByitemId(String itemId) throws IOException {
        String itemJson=itemServiceFeignClient.queryItemByItemId(itemId);
        Item item = objectMapper.readValue(itemJson,Item.class);
        return item;
    }
}
