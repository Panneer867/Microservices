package com.micro.services.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.micro.services.entity.EmployeeEntity;
import com.micro.services.exception.EmployeNotFoundException;
import com.micro.services.model.Employee;
import com.micro.services.repo.EmployeeRepository;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee employee) {

		if (employee.getId() == null) {
			employee.setId(UUID.randomUUID().toString());
		}

		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		employeeRepository.save(employeeEntity);

		return employee;
	}

	@Override
	public Employee get(String id) {
		Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);

		Employee employee = new Employee();

		if (employeeEntity.isPresent()) {

			BeanUtils.copyProperties(employeeEntity.get(), employee);
		} else {

			throw new EmployeNotFoundException("Employee Not Found");
		}

		return employee;
	}

	@Override
	public String delEmpById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> employees = employeeRepository.findAll();
		List<Employee> employeesList = employees.stream().map(employeeEntity -> {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
			return employee;
		}).collect(Collectors.toList());
		return employeesList;
	}

}
