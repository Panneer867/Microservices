package com.micro.services.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.micro.services.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

}
