package com.example.employeeAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeAPI.model.Employee;
import com.example.employeeAPI.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getEmployeeList() {
		return (List<Employee>) this.employeeRepository.findAll();
	}

	public Employee saveEmployee(Employee emp) {
		return this.employeeRepository.save(emp);
	}

	public Employee updateEmployee(Employee emp, int id) {
		Optional<Employee> empObj = this.employeeRepository.findById(id);

		if (empObj.isPresent()) {
			emp.setId(id);
		}
		return this.employeeRepository.save(emp);

	}

	public Optional<Employee> getEmployeeById(int id) {
		return this.employeeRepository.findById(id);
	}

	public void deleteEmployee(int id) {

		this.employeeRepository.deleteById(id);
	}

}
