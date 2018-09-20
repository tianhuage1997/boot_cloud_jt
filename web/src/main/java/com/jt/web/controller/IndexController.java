package com.jt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	// 跳转到首页index.jsp
	//WEB-INF/views/index.jsp
	@RequestMapping("index.html")
	public String goIndex() {
		return "index";
	}
	
}