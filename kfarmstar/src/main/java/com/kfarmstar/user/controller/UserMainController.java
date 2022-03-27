package com.kfarmstar.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMainController {
	
	@GetMapping("/userMain")
	public String main(Model model) {
		
		model.addAttribute("title", "Food Refurb");
		
		return "userMain";
	}
	
}
