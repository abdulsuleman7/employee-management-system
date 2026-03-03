

package com.codec.employeemanagement.service;

import com.codec.employeemanagement.model.Employee;
import com.codec.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Save Employee
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Get Employee By Id
    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}

