package com.vu.localhost.poss.service.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.vu.localhost.poss.service.model.CreateService;
import com.vu.localhost.poss.service.model.Service;
import com.vu.localhost.poss.service.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.vu.localhost.poss.tenant.Tenant;
import com.vu.localhost.poss.tenant.TenantRepository;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository serviceRepository;
    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Optional<Service> getServiceById(Long serviceId) {
        return serviceRepository.findById(serviceId);
    }

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Service createService(Service service) {
        // Additional business logic can be added here
        return serviceRepository.save(service);
    }

    public void deleteService(Long serviceId) {
        serviceRepository.deleteById(serviceId);
    }

    public Service updateService(Long serviceId, CreateService serviceDetails) {
        return serviceRepository.findById(serviceId).map(service -> {
            if (serviceDetails.getName() != null) {
                service.setName(serviceDetails.getName());
            }
            if (serviceDetails.getDuration() != null) {
                service.setDuration(serviceDetails.getDuration());
            }
            if (serviceDetails.getPrice() != null) {
                service.setPrice(serviceDetails.getPrice());
            }
            // Handling tenant relationship
            if (serviceDetails.getTenant() != null) {
                Tenant tenant = tenantRepository.findById(serviceDetails.getTenant())
                        .orElseThrow(() -> new EntityNotFoundException("tenant not found"));
                service.setTenant(tenant);
            }
            if (serviceDetails.getDescription() != null) {
                service.setDescription(serviceDetails.getDescription());
            }
            return serviceRepository.save(service);
        }).orElseThrow(() -> new IllegalArgumentException("service not found with id " + serviceId));
    }
}
