package com.jt.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jt.common.vo.EasyUIResult;
import com.jt.manage.mapper.ItemDescMapper;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;

@Service
public class ItemService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemDescMapper itemDescMapper;

	public EasyUIResult queryItems(Integer page, Integer rows) {
		//page=(page-1)*rows;
		
		PageHelper pageHelper=new PageHelper();
		pageHelper.startPage(page, rows);
		
		List<Item> itemList=itemMapper.selectAll();
		// select * from tb_item limit page,rows
		//select count(*) from tb_item
		//List<Item> itemList2=itemMapper.selectAll();
		
		PageInfo info =new PageInfo(itemList);
		
		List items = info.getList();//20��,30��list��ѯ���
		int total = (int) info.getTotal();
		EasyUIResult result=new EasyUIResult();
		result.setRows(items);
		result.setTotal(total);
		return result;
	}

	public Integer queryItemCount() {
		int total = itemMapper.selectCount(null);
		return total;
	}
	
	//������Ʒ
	public void saveItem(Item item, String desc) {
		
		item.setStatus(1);
		item.setCreated(new Date());
		item.setUpdated(item.getCreated());
		itemMapper.insertSelective(item);
		
		ItemDesc itemDesc=new ItemDesc();
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(item.getCreated());
		itemDesc.setUpdated(item.getCreated());
		
		itemDesc.setItemId(item.getId());
		itemDescMapper.insertSelective(itemDesc);
	}

	public void updateItem(Item item, String desc) {
		
		item.setUpdated(new Date());
		itemMapper.updateByPrimaryKeySelective(item);
		ItemDesc itemDesc=new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setUpdated(new Date());
		itemDesc.setItemDesc(desc);
		itemDescMapper.updateByPrimaryKeySelective(itemDesc);
	}

	public void deleteItems(Long[] ids) {
		for (Long id : ids) {
			itemMapper.deleteByPrimaryKey(id);
			try {
				itemDescMapper.deleteByPrimaryKey(id);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ItemDesc queryItemDesc(Long itemId) {
		try {
			ItemDesc desc = itemDescMapper.
					selectByPrimaryKey(itemId);
			return desc;
		}catch(Exception e) {
			e.printStackTrace();
			ItemDesc desc=new ItemDesc();
			desc.setItemId(itemId);
			desc.setItemDesc("");
			return desc;
		}
		
	}

	public  Item queryItemById(String itemId){
		Long itemIdCase=Long.parseLong(itemId);
		Item item = itemMapper.selectByPrimaryKey(itemIdCase);
		return  item;
	}
}







