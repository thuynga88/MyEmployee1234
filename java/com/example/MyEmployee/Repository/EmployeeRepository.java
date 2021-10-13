package com.example.MyEmployee.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.MyEmployee.Entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findByAge(Integer age);
   
}
