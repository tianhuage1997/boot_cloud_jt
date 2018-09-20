package com.jt.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.mapper.MyMapper;

import com.jt.manage.pojo.Item;


public interface ItemMapper extends MyMapper<Item>{

	//List<Item> queryItems(@Param(value="page") Integer page, @Param(value="rows") Integer rows);
	
}
