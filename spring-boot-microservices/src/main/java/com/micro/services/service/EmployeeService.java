package com.micro.services.service;

import com.micro.services.model.Employee;

public interface EmployeeService {

	Employee postEmp(Employee employee);

	Employee getEmp(String id);

	String delEmpById(String id);
}
