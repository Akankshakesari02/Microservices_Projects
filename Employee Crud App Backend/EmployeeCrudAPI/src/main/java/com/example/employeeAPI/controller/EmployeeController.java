package com.example.employeeAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeAPI.model.Employee;
import com.example.employeeAPI.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	private List<Employee> showAllEmployee() {
		return employeeService.getEmployeeList();
	}

	@PostMapping("/save")
	private Employee saveEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}

	@PutMapping("/update/{id}")
	private Employee updateEmployee(@RequestBody Employee emp, @PathVariable int id) {
		return employeeService.updateEmployee(emp, id);
	}
	
	@GetMapping("/emp/{id}")
	private Optional<Employee>  getEmployeeById(@PathVariable int id) {
		return  employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping("delete/{id}")
	private void deleteEmployee(@PathVariable int id) {
	   this.employeeService.deleteEmployee(id);
	
	}

}
