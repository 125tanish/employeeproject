package com.example.mytestproject2.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.mytestproject2.entity.Employee;
import com.example.mytestproject2.services.EmployeeService;

@RestController
@CrossOrigin
public class MyController {
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/addEmp")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		this.empService.addEmployee(employee);
		return ResponseEntity.ok("Employee Added Succesfully ");
	}
	@GetMapping("/getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> employees=this.empService.getAllEmployee();
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}
	@GetMapping("/getEmpById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String id)
	{
		Employee employee=this.empService.getEmployeeById(Long.parseLong(id));
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String id)
	{
		this.empService.deleteEmployee(Long.parseLong(id));
		 return ResponseEntity.ok("Employee Deleted Successfully");
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(@PathVariable String id,@RequestBody Employee employee)
	{
		this.empService.updateById(Long.parseLong(id),employee);
		return ResponseEntity.ok("update successfully");
	}
	
	@GetMapping("/byName/{name}")
	public ResponseEntity<Employee> findEmployeetByName(@PathVariable String name)
	{
		 Employee emp=empService.findEmployeeByName(name);
		 if(name==null)
		 {
			 return ResponseEntity.notFound().build();
		 }
		 return ResponseEntity.ok(emp);
	}
	
	@GetMapping("/byNameAndAge/{name}/{age}")
	public ResponseEntity<Employee> findEmployeeByNameAndAge(@PathVariable String name,@PathVariable Integer age)
	{
		Employee emp=empService.findEmployeeByNameAndAge(name,age);
		if(emp==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(emp);
		
	}
	
	@GetMapping("/bySalaryGreaterThan/{salary}")
	public ResponseEntity<List<Employee>> findEmployeeBySalaryGreaterThan(@PathVariable double salary)
	{
		List<Employee> emp=empService.findEmployeeBySalaryGreaterThan(salary);
		if(emp==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(emp);
	}
	
	@GetMapping("/byDepartment/{department}")
	public ResponseEntity<List<Employee>> findEmployeeByDepartment(@PathVariable String department)
	{
		List<Employee> emp=empService.findEmployeeByDepartment(department);
		if(emp==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(emp);
	}
	
	@GetMapping("/byAge/{age}")
	public ResponseEntity<List<Employee>> findEmployeeByAge(@PathVariable String age)
	{
		List<Employee> emp=empService.findEmployeeByAge(Integer.parseInt(age));
		if(emp==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(emp);
	}
	
	
}
