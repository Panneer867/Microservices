package com.micro.services.service;

import java.util.List;
import com.micro.services.model.Employee;

public interface EmployeeService {

	List<Employee> postEmploye(Employee user);

	Employee getEmploye(String id);

	String delEmpById(String id);
}
