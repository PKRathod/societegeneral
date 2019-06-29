package com.socity.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.socity.general.model.Employee;
import com.socity.general.services.EmployeeService;
import com.socity.general.util.Base;
import com.socity.general.util.RestException;

@RestController
@RequestMapping("/vi/sg")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public Base registerEmployee(@RequestBody Employee employee) {
		Base base = new Base();
		base = employeeService.registerEmployee(employee);
	return base;
	}
	
	@RequestMapping(value="/list/{firstName}",method=RequestMethod.GET)
	public Base employeeList(@PathVariable("firstName") String firstName) {
		Base base = new Base();   
		base = employeeService.getEmployeeList(firstName);
		return base;
		}
	
	
	
	
	
	
}
