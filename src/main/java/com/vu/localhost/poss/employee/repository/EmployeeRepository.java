package com.vu.localhost.poss.employee.repository;
import com.vu.localhost.poss.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e.id FROM Employee e WHERE e.tenantId = :tenantId")
    public List<Long> getAllIdsByTenantId(Long tenantId);

    
}