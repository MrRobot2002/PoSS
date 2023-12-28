package com.vu.localhost.poss.employee.repository;

import com.vu.localhost.poss.employee.model.EmployeeServiceId;
import com.vu.localhost.poss.employee.model.EmployeeServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeServicesRepository  extends JpaRepository<EmployeeServices, EmployeeServiceId> {

    @Query("SELECT es FROM EmployeeServices es WHERE es.id.employeeId = ?1")
    List<EmployeeServices> findByEmployeeId(Long employeeId);

    @Query("SELECT es FROM EmployeeServices es WHERE es.id.serviceId = ?1")
    List<EmployeeServices> findByServiceId(Long serviceId);

    @Query("SELECT es FROM EmployeeServices es WHERE es.id.employeeId = ?1 AND es.id.serviceId = ?2")
    List<EmployeeServices> findByEmployeeIdAndServiceId(Long employeeId, Long serviceId);
}

