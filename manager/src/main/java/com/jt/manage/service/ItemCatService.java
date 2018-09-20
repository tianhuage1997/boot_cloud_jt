package com.jt.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.pojo.ItemCat;

@Service
public class ItemCatService {
	@Autowired
	private ItemCatMapper itemCatMapper;
	public List<ItemCat> queryItemCatAll() {
		
		List<ItemCat> itemCatList = itemCatMapper.selectAll();
		return itemCatList;
	}
	public List<ItemCat> queryItemCats(Long id) {
		
		List<ItemCat> itemCatList=itemCatMapper.queryItemCats(id);
		return itemCatList;
	}

}
