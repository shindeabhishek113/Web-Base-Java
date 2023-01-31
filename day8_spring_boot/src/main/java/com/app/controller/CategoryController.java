package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	private 
	
	public CategoryController() {
		System.out.println("in ctr Category ");
		
	}
	
	@GetMapping("/choose")	
	public String showCategoryForm() {
		
		System.out.println("in category form method ");
		
		return "/category/choose_category";
	}
	
	@PostMapping("/choose")
	
	public String processChoosenCategory(@RequestParam String categoryName,Model map) {
		
		
		return
	}
	

}
