package com.vu.localhost.poss.employee.service;
import com.vu.localhost.poss.employee.model.EmployeeServices;
import com.vu.localhost.poss.employee.repository.EmployeeServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServicesService {

    private final EmployeeServicesRepository employeeServiceRepository;

    @Autowired
    public EmployeeServicesService(EmployeeServicesRepository employeeServiceRepository) {
        this.employeeServiceRepository = employeeServiceRepository;
    }

    public List<EmployeeServices> getAllEmployeeServices() {
        return employeeServiceRepository.findAll();
    }

    public List<EmployeeServices> getServicesByEmployeeId(Long employeeId) {
        return employeeServiceRepository.findByEmployeeId(employeeId);
    }

    public List<EmployeeServices> getServicesByServiceId(Long serviceId) {
        return employeeServiceRepository.findByServiceId(serviceId);
    }

    public Boolean isEmployeeAssignedToService(Long employeeId, Long serviceId) {
        return employeeServiceRepository.findByEmployeeIdAndServiceId(employeeId, serviceId).size() > 0;
    }

}
