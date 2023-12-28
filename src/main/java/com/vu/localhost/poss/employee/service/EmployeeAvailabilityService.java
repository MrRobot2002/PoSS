package com.vu.localhost.poss.employee.service;
import com.vu.localhost.poss.employee.model.EmployeeAvailability;
import com.vu.localhost.poss.employee.repository.EmployeeAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeAvailabilityService {

    private final EmployeeAvailabilityRepository employeeAvailabilityRepository;

    @Autowired
    public EmployeeAvailabilityService(EmployeeAvailabilityRepository employeeAvailabilityRepository) {
        this.employeeAvailabilityRepository = employeeAvailabilityRepository;
    }

    public List<EmployeeAvailability> getAvailabilities(LocalDateTime start, LocalDateTime end, List<Long> employeeIds) {
        return employeeAvailabilityRepository.findByEmployeeIdInAndStartTimeBetween(employeeIds, start, end);

    }

}
