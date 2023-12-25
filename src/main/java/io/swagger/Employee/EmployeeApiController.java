package io.swagger.Employee;

import io.swagger.Role.Role;
import io.swagger.Role.RoleRepository;
import io.swagger.Tenant.Tenant;
import io.swagger.Tenant.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class EmployeeApiController implements EmployeeApi {

    private final EmployeeService employeeService;
    @Autowired
    private TenantRepository tenantRepository; // Inject the Tenant repository
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public EmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Implement the getEmployee method from the EmployeeApi interface
    @Override
    public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") Long id) {
        System.out.println("getemployeebyid " + id);
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Implement the updateUser method from the EmployeeApi interface
    @Override
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Long id,
            @RequestBody CreateEmployee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Implement the createEmployee method from the EmployeeApi interface
    @Override
    public ResponseEntity<Employee> createEmployee(@RequestBody CreateEmployee createEmployeeDTO) {
        System.out.println("Received request to create employee: {}" + createEmployeeDTO);
        Employee employee = convertToEntity(createEmployeeDTO); // You need to convert DTO to Employee entity
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.ok(createdEmployee);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Long employeeId) {
        try {
            // Call the service to delete the employee by ID
            employeeService.deleteEmployee(employeeId);

            // Return an appropriate response
            // HttpStatus.NO_CONTENT indicates that the action was successful but there's no
            // content to return.
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            // If the employee doesn't exist, you might want to return a 404 Not Found.
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // For other exceptions, you might return a 500 Internal Server Error
            // Log the exception for debugging purposes
            // (Make sure to import the necessary Logger at the beginning of your class)
            System.err.println("Error occurred while trying to delete employee: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Helper method to convert CreateEmployee DTO to Employee entity

    @Transactional
    private Employee convertToEntity(CreateEmployee createEmployeeDTO) {
        Employee employee = new Employee();
        employee.setName(createEmployeeDTO.getName());
        /// System.out.println("tenant: " + tenantRepository.);

        if (createEmployeeDTO.getRole() != null) {
            Role role = roleRepository.findById(createEmployeeDTO.getRole())
                    .orElseThrow(() -> new EntityNotFoundException("Role not found"));
            employee.setRole(role);
        }
        // Handling Tenant relationship
        if (createEmployeeDTO.getTenant() != null) {
            Tenant tenant = tenantRepository.findById(createEmployeeDTO.getTenant())
                    .orElseThrow(() -> new EntityNotFoundException("Tenant not found"));
            employee.setTenant(tenant);
        }

        employee.setShortCode(createEmployeeDTO.getShortCode());
        return employee;
    }
}
