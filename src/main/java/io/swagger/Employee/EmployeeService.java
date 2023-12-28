package io.swagger.Employee;

import io.swagger.Role.Role;
import io.swagger.Role.RoleRepository;
import io.swagger.Tenant.Tenant;
import io.swagger.Tenant.TenantRepository;

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
        System.out.println("Service Employees " + employeeRepository.findAll());
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
                        .orElseThrow(() -> new EntityNotFoundException("Role not found"));
                employee.setRole(role);
            }

            if (employeeDetails.getTenantId() != null) {
                employee.setTenantId(employeeDetails.getTenantId());
            }

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
}
