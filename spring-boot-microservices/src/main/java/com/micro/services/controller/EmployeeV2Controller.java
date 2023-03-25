package com.micro.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.micro.services.model.Employee;
import com.micro.services.service.EmployeeService;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {
	

	@Qualifier("employeeV2ServiceImpl")
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		return employee;
	}
}
