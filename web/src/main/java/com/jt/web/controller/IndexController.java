package com.jt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	// 跳转到首页index.jsp
	//WEB-INF/views/index.jsp
	@RequestMapping("index.html")
	public String goIndex() {
		return "index";
	}


	/*
	跳转到注册/登录界面页面.通过restful风格去匹配对应的界面
	 */
	@RequestMapping("/user/{name}")
   public  String goRegister(@PathVariable("name") String name){
   	return  name;
   }


}
