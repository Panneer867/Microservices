package com.micro.services.service;

import java.util.List;

import com.micro.services.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	Employee get(String id);

	String delEmpById(String id);

	List<Employee> getAllEmployees();
}
