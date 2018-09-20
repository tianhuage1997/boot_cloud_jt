package com.jt.manage.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ComponentScan(basePackages="com.jt.manage.config")
public class IndexController {
	
	/*//转向首页
	@RequestMapping("/page/index")
	public String goIndex() {
		return "index";//WEB-INF/views/index.jsp
	}
	//转向新增商品
	@RequestMapping("/page/item-add")
	public String goItemAdd() {
		return "item-add";
	}*/
	@RequestMapping("/page/{pageName}")

	public String goPages(@PathVariable String pageName) {
		//WEB-INF/views/index.jsp
		return pageName;

	}
}











