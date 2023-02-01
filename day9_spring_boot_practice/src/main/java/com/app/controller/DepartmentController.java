package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.DepartmentDao;

@Controller

public class DepartmentController {
	
	@Autowired
	private DepartmentDao deptDao;
	
	public DepartmentController() {
		
		System.out.println("in dept Constructor");
	}

	@GetMapping("/")
	public String  getAllDeptNames(Model map) {
		System.out.println("in dept controller");
		map.addAttribute("deptname",deptDao.getDeptNames());
		return "/department/deptname";
	}
}
