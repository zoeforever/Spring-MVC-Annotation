package com.vistek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vistek.service.HelloService;

@Controller
public class HelloController {

	@Autowired
	HelloService helloService; 
	
	@ResponseBody
	@RequestMapping("/hello")
	public String Hello() {
		String hello = helloService.sayHello("tomcat");
		return hello;
	}
	
	@RequestMapping("suc")
	public String success() {
		return "success";
	}
}
