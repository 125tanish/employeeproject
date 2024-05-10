package com.example.mytestproject2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mytestproject2.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByName(String name);
    
    Employee findByNameAndAge(String name,Integer age);
    
    List<Employee> findBySalaryGreaterThan(double salary);
    
    List<Employee> findByDepartment(String department);
    
    List<Employee> findByAge(Integer age);
    
    //List<Employee> findEmployeeByNameAsc();
    
}
