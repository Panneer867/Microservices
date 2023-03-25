package com.micro.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.services.model.Employee;
import com.micro.services.service.EmployeeService;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeV1Controller {

	@Qualifier("employeeV1ServiceImpl")
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public Employee post(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@GetMapping("/{id}")
	public Employee get(@PathVariable String id) {
		return employeeService.get(id);
	}

	@DeleteMapping("/{id}")
	public String del(@PathVariable String id) {
		return employeeService.delEmpById(id);
	}
}
