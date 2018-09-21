package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.service.ItemService;

@Controller
@RequestMapping("item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	///item/query
	@RequestMapping("query")
	@ResponseBody
	public EasyUIResult queryItems(Integer page,Integer rows){
		EasyUIResult result = itemService.queryItems(page,rows);
		return result;
	}
	
	
	//item/save
	@RequestMapping("save")
	@ResponseBody
	public SysResult saveItem(Item item,String desc) {
		try {
			itemService.saveItem(item,desc);
			//sysResult,status=200
			return SysResult.oK();
			//new SysResult(null);
			//status=200;msg="ok",data=null
		}catch(Exception e) {
		
			return SysResult.build(201, "新增失败"+e.getMessage());
		}
	}
	//��Ʒ�޸�
	@RequestMapping("update")
	@ResponseBody
	public SysResult updateItem(Item item,String desc) {
		try {
			itemService.updateItem(item,desc);
			return SysResult.oK();
		}catch(Exception e) {
			return SysResult.build(201, "修改失败"+e.getMessage());
		}
	}
	//ɾ����Ʒ��
	@RequestMapping("delete")
	@ResponseBody
	public SysResult deleteItems(Long[] ids) {
		try {
			itemService.deleteItems(ids);
			return SysResult.oK();
		}catch(Exception e) {
			return SysResult.build(201, "ɾ��ʧ��"+e.getMessage());		
		}
	}
	
	///query/item/desc/1474391958
	@RequestMapping("/query/item/desc/{itemId}")
	@ResponseBody
	public SysResult queryItemDesc(@PathVariable Long itemId) {
		ItemDesc desc=itemService.queryItemDesc(itemId);
		return SysResult.oK(desc);
	}

	//基于商品id，查询商品数据
	@RequestMapping("itemById")
	@ResponseBody
	public Item queryItemById(String itemId){
		Item item = itemService.queryItemById(itemId);
		return  item;
	}
}








