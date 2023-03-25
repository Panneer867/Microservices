package com.micro.services.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.micro.services.exception.EmployeNotFoundException;
import com.micro.services.model.Employee;

@Service
public class EmployeeV1ServiceImpl implements EmployeeService {

	List<Employee> employeesList = new ArrayList<>();

	@Override
	public Employee save(Employee employee) {

		if (employee.getId() == null) {
			employee.setId(UUID.randomUUID().toString());
		}
		employeesList.add(employee);

		return employee;
	}

	@Override
	public Employee get(String id) {

		return employeesList.stream().filter(s -> s.getId().equals(id)).findFirst()
				.orElseThrow(() -> new EmployeNotFoundException("Employee not Found with this id"));
	}

	@Override
	public String delEmpById(String id) {

		Employee user = employeesList.stream().filter(e -> e.getId().equalsIgnoreCase(id)).findFirst().get();

		employeesList.remove(user);
		return "Employee has been deleted with this id " + id;
	}

}
