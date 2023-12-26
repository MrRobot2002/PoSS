package io.swagger.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Optional<Service> getServiceById(Long serviceId) {
        return serviceRepository.findById(serviceId);
    }
}
