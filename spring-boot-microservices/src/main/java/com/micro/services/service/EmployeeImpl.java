package com.micro.services.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.micro.services.exception.EmployeNotFoundException;
import com.micro.services.model.Employee;

@Service
public class EmployeeImpl implements EmployeeService {

	List<Employee> ll = new ArrayList<>();

	@Override
	public List<Employee> postEmploye(Employee user) {

		if (user.getId() == null) {
			user.setId(UUID.randomUUID().toString());
		}
		ll.add(user);

		return ll;
	}

	@Override
	public Employee getEmploye(String id) {

		return ll.stream().filter(s -> s.getId().equals(id)).findFirst()
				.orElseThrow(() -> new EmployeNotFoundException(" Employee not Found"));
	}

	@Override
	public String delEmpById(String id) {

		Employee user = ll.stream().filter(e -> e.getId().equalsIgnoreCase(id)).findFirst().get();
		
		ll.remove(user);
		return "Employee has ben deleted with the id " + id;
	}

}
