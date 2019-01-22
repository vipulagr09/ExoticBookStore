package com.vipul.test.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vipul.test.bookstore.service.BookStoreService;

@Controller
public class BookStoreWebController {
	
	@Autowired
	private BookStoreService bookStoreService;
	
	@RequestMapping("/")
	public String getLoginPage() {
		System.out.println(" sendiong to first page ");
		return "userlogin";
	}
	
	@PostMapping("/validateUser")
	public String validateUser(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass, Model model) {
		
		
		String nextScreen = "welcome";
		
		boolean isValidUser = bookStoreService.validateUser(userName, userPass);
		
		if(isValidUser) {
			model.addAttribute("userName",userName);
		}else {
			nextScreen ="userlogin";
			model.addAttribute("errMsg" ,userName + " is not a vlaid User");
		}
		
		return nextScreen;
	}
}
