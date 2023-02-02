package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;
import com.app.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl empService;
	
	public EmployeeController() {
		System.out.println("in Employee Controller");
	}
	@GetMapping
	public  List<Employee> getAllEMployees(){
		
		return empService.showAllEmployees();
	}
}
