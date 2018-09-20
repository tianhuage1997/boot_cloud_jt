package com.jt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.manage.pojo.ItemCat;
import com.jt.manage.service.ItemCatService;

@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("item/cat/")
	@ResponseBody
	public List<ItemCat> queryItemCatAll(){
		List<ItemCat> itemCatList=itemCatService.queryItemCatAll();
		return itemCatList;
	}
	@RequestMapping("item/cat/list")
	@ResponseBody
	public List<ItemCat> queryItemCats(
			@RequestParam(defaultValue="0") Long id){
		List<ItemCat> itemCatList=itemCatService.queryItemCats(id);
		return itemCatList;
	}
}





