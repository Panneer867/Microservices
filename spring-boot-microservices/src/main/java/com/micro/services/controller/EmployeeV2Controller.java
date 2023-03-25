package com.micro.services.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.micro.services.model.Employee;

@RestController
@RequestMapping("/v2")
public class EmployeeV2Controller {
	

	@PostMapping("/postuser")
	public Employee save(@RequestBody Employee employee) {
		return employee;
	}
}
