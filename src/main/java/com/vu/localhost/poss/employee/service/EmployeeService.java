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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;
    private RoleRepository roleRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Create a new Employee
    public Employee createEmployee(Employee employee) {
        // Additional business logic can be added here
        return employeeRepository.save(employee);
    }

    // Retrieve a single Employee by ID
    public Optional<Employee> getEmployeeById(Long employeeId) {
        Employee c = employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("employee not found"));
        logger.info("employee: {}", c);
        return employeeRepository.findById(employeeId);
    }

    // Retrieve all employees
    public List<Employee> getAllEmployees() {
        logger.info("employee found {}", employeeRepository.findAll());
        return employeeRepository.findAll();
    }

    // Update an Employee's information
    public Employee updateEmployee(Long employeeId, CreateEmployee employeeDetails) {
        logger.info("employee found {}", employeeRepository.findById(employeeId));
        return employeeRepository.findById(employeeId).map(employee -> {
            if (employeeDetails.getName() != null) {
                employee.setName(employeeDetails.getName());
            }

            if (employeeDetails.getRole() != null) {
                Role role = roleRepository.findById(employeeDetails.getRole())
                        .orElseThrow(() -> new EntityNotFoundException("role not found"));
                employee.setRole(role);
            }
            // Handling tenant relationship
            employee.setTenantId(employeeDetails.getTenantId());

            if (employeeDetails.getShortCode() != null) {
                employee.setShortCode(employeeDetails.getShortCode());
            }

            return employeeRepository.save(employee);
        }).orElseThrow(() -> new IllegalArgumentException("Employee not found with id " + employeeId));
    }

    // Delete a employee by ID
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Long> getAllEmployeesIdsByTenantId(Long tenantId) {
        return employeeRepository.getAllIdsByTenantId(tenantId);
    }
}
