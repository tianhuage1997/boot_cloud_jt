package com.jt.manage.mapper;

import java.util.List;

import com.jt.common.mapper.MyMapper;
import com.jt.manage.pojo.ItemCat;

public interface ItemCatMapper extends MyMapper<ItemCat>{
	
	List<ItemCat> queryItemCats(Long id);


	
}
