package com.example.MyEmployee.service;

import java.util.List;

import com.example.MyEmployee.Entity.Employee;

public interface EmployeeService {
Iterable<Employee> findAll();
	
	List<Employee> search(long age);
	
	void save(Employee contact);
	
	void delete(Integer id);

}
