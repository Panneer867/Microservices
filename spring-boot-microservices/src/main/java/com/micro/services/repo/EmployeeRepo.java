package com.micro.services.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.micro.services.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {

}
