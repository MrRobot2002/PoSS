package com.vu.localhost.poss.employee.repository;

import com.vu.localhost.poss.employee.model.EmployeeAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface EmployeeAvailabilityRepository extends JpaRepository<EmployeeAvailability, Long> {


    List<EmployeeAvailability> findByEmployeeIdAndStartTimeBetween(Long employeeId, LocalDateTime start, LocalDateTime end);

    List<EmployeeAvailability> findByEndTimeBetween(LocalDateTime start, LocalDateTime end);

    List<EmployeeAvailability> findByEmployeeIdInAndStartTimeBetween(List<Long> employeeIds, LocalDateTime start, LocalDateTime end);
}


