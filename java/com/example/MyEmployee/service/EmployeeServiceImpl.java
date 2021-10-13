package com.example.MyEmployee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.MyEmployee.Entity.Employee;
import com.example.MyEmployee.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeService ;
	
	@Override
	public Iterable<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeService.findAll();
	}

	@Override
	public List<Employee> search(long age) {
		// TODO Auto-generated method stub
		return null;
	}																																																																																																										

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeService.save(employee);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		employeeService.delete(id);
	}

}
