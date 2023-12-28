package com.vu.localhost.poss.employee.repository;
import com.vu.localhost.poss.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}