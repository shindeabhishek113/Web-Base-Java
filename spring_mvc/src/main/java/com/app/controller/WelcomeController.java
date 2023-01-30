package com.app.controller;

import org.hibernate.type.LocalDateTimeType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	public WelcomeController() {
		System.out.println("in welcome ctr");
	}
	
	@RequestMapping
	public String showWelcomePage(Model map) {
		
		map.addAttribute("server_date",new LocalDateTimeType());
		return "/index";
		
		
	}

}
