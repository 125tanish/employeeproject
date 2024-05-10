package com.example.mytestproject2.services;

import java.util.*;

import com.example.mytestproject2.entity.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeById(Long id);
	
	public void deleteEmployee(Long id);
	
	public void updateById(Long id,Employee employee);
	
	public Employee findEmployeeByName(String name);
	
	public Employee findEmployeeByNameAndAge(String name,Integer age);
	
	public List<Employee> findEmployeeBySalaryGreaterThan(double salary);
	
	public List<Employee> findEmployeeByDepartment(String department);
	
	public List<Employee> findEmployeeByAge(Integer age);
	
	//public List<Employee> findEmployeeByNameAsc();
}
