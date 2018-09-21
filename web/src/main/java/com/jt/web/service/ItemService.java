package com.jt.web.service;

import com.jt.web.pojo.Item;

import java.io.IOException;

public interface ItemService {
    /* 查询商品详情 */
    Item queryItemByitemId(String  itemId) throws IOException;
}
