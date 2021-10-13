package com.example.MyEmployee.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.MyEmployee.Entity.Employee;
import com.example.MyEmployee.Repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@CrossOrigin
	@GetMapping("/employees")
	public List<Employee> getAllCustomers() {
		List<Employee> employees = new ArrayList<>();
		repository.findAll().forEach(employees::add);

		return employees;
	}

	@PostMapping("/employee")
	public Employee postCustomer(@RequestBody Employee employee) {

		 Employee _employee = repository.save(new Employee(employee.getFirstname(), employee.getLastname()
				, employee.getFullname(), employee.getAge(), employee.getAddress(),employee.getGender(), 
				employee.getPhone(), employee.getEmail(), employee.getSkill(), employee.getDescription()));
		return _employee;
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id) {
		System.out.println("Delete Employee with ID = " + id + "...");

		repository.delete(id);

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	@GetMapping("employees/age/{age}")
	public List<Employee> findByAge(@PathVariable int age) {

		List<Employee> employees = repository.findByAge(age);
		return employees;
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateCustomer(@PathVariable("id") int id, @RequestBody Employee employee) {
		System.out.println("Update Employee with ID = " + id + "...");

		Optional<Employee> employeeData = Optional.ofNullable(repository.findOne(id));

		if (employeeData.isPresent()) {
			Employee _employee = employeeData.get();
			_employee.getFirstname();
			_employee.getLastname();
		    _employee.getFullname();
			_employee.getAge();
			_employee.getAddress();
			_employee.getGender();
			_employee.getPhone();
			_employee.getEmail();
			_employee.getSkill();
			_employee.getDescription();
			return new ResponseEntity<>(repository.save(_employee), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
