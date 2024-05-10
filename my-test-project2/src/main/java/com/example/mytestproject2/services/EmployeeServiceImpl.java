package com.example.mytestproject2.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mytestproject2.entity.Employee;
import com.example.mytestproject2.repository.EmployeeRepository;

@Service
public   class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepository;
	
	public void addEmployee(Employee employee) {
		empRepository.save(employee);
	}
	
	public List<Employee> getAllEmployee()
	{
		return this.empRepository.findAll();
	}
	
	public Employee getEmployeeById(Long id)
	{
		return this.empRepository.findById(id).orElse(null);
	}
   
	public void deleteEmployee(Long id)
	{
		empRepository.deleteById(id);
	}
	
	public void updateById(Long id,Employee employee)
	{
		Employee emp=empRepository.findById(id).orElse(null);
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		emp.setDepartment(employee.getDepartment());
		emp.setAge(employee.getAge());
		
		empRepository.save(emp);
	}
	
	public Employee findEmployeeByName(String name)
	{
		return empRepository.findByName(name);
	}
	 
	public Employee findEmployeeByNameAndAge(String name,Integer age)
	{
		return empRepository.findByNameAndAge(name,age);
	}
	
	public List<Employee> findEmployeeBySalaryGreaterThan(double salary)
	{
		return empRepository.findBySalaryGreaterThan(salary);
	}
	
	public List<Employee> findEmployeeByDepartment(String department)
	{
		 return empRepository.findByDepartment(department);
	}
	
	public List<Employee> findEmployeeByAge(Integer age)
	{
		return empRepository.findByAge(age);
	}
	
}
