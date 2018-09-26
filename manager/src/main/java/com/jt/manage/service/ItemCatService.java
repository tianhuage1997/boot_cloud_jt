package com.jt.manage.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.manage.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.pojo.ItemCat;
import org.springframework.util.StringUtils;

@Service
public class ItemCatService {
	@Autowired
	private ItemCatMapper itemCatMapper;

	@Autowired
	private RedisService redisService;

	private  static final ObjectMapper objectMapper = new ObjectMapper();

	public List<ItemCat> queryItemCatAll() {
		
		List<ItemCat> itemCatList = itemCatMapper.selectAll();
		return itemCatList;
	}
	public List<ItemCat> queryItemCats(Long id) throws IOException {
		//商品分类菜单，添加redis缓存
		String itemId = "ITEM_CAT_LIST_"+id;
		if (StringUtils.isEmpty(redisService.get(itemId))){
			System.err.println("我要存缓存了");
			List<ItemCat> itemCatList=itemCatMapper.queryItemCats(id);
			String itemCatListJSON=objectMapper.writeValueAsString(itemCatList);
			redisService.set(itemId,itemCatListJSON);
			return itemCatList;
		}else {
			System.err.println("我从缓存拿数据了");
			String itemCatListJSON=redisService.get(itemId);
			//将返回的json串变成对象
			ItemCat[] itemCats = objectMapper.readValue(itemCatListJSON,ItemCat[].class);
			List<ItemCat> itemCatList2 = new ArrayList<>();
			System.out.println();
			for (ItemCat itemCat:itemCats){
					itemCatList2.add(itemCat);
			}
			return  itemCatList2;

		}



	}

}
