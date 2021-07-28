package com.example.employeeAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeeAPI.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	

}
