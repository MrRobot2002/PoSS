package com.vu.localhost.poss.employee.service;

import com.vu.localhost.poss.employee.model.CreateEmployee;
import com.vu.localhost.poss.employee.model.Employee;
import com.vu.localhost.poss.employee.repository.EmployeeRepository;
import com.vu.localhost.poss.role.Role;
import com.vu.localhost.poss.role.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Create a new employee
    public Employee createEmployee(Employee employee) {
        // Additional business logic can be added here
        return employeeRepository.save(employee);
    }

    // Retrieve a single employee by ID
    public Optional<Employee> getEmployeeById(Long employeeId) {
        Employee c = employeeRepository.findById(employeeId).get();
        System.out.println(c);
        return employeeRepository.findById(employeeId);
    }

    // Retrieve all employees
    public List<Employee> getAllEmployees() {
        System.out.println("service Employees " + employeeRepository.findAll());
        return employeeRepository.findAll();
    }

    // Update a employee's information
    public Employee updateEmployee(Long employeeId, CreateEmployee employeeDetails) {
        System.out.println("employeeDetails " + employeeDetails);
        return employeeRepository.findById(employeeId).map(employee -> {
            if (employeeDetails.getName() != null) {
                employee.setName(employeeDetails.getName());
            }

            if (employeeDetails.getRole() != null) {
                Role role = roleRepository.findById(employeeDetails.getRole())
                        .orElseThrow(() -> new EntityNotFoundException("role not found"));
                employee.setRole(role);
            }

            if (employeeDetails.getTenantId() != null) {
                employee.setTenantId(employeeDetails.getTenantId());
            }

            if (employeeDetails.getShortCode() != null) {
                employee.setShortCode(employeeDetails.getShortCode());
            }

            return employeeRepository.save(employee);
        }).orElseThrow(() -> new IllegalArgumentException("employee not found with id " + employeeId));
    }

    // Delete a employee by ID
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
