package com.vu.localhost.poss.service.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.vu.localhost.poss.service.model.Service;
import com.vu.localhost.poss.service.model.ServiceRequestDTO;
import com.vu.localhost.poss.service.repository.ServiceRepository;
import com.vu.localhost.poss.tenant.model.Tenant;
import com.vu.localhost.poss.tenant.repository.TenantRepository;

import org.springframework.beans.factory.annotation.Autowired;

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

    public Service updateService(Long serviceId, ServiceRequestDTO serviceDetails) {
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
                Optional<Tenant> tenantOptional = tenantRepository.findById(serviceDetails.getTenant());
                if (tenantOptional.isPresent()) {
                    Tenant tenant = tenantOptional.get();
                    Long tenantId = tenant.getId();
                    service.setTenant(tenantId);
                } else {
                    throw new EntityNotFoundException("tenant not found");
                }
            }
            if (serviceDetails.getDescription() != null) {
                service.setDescription(serviceDetails.getDescription());
            }
            return serviceRepository.save(service);
        }).orElseThrow(() -> new IllegalArgumentException("service not found with id " + serviceId));
    }

    public Long getServiceDuration(Long serviceId) {

        return serviceRepository.findById(serviceId).map(Service::getDuration)
                .orElseThrow(() -> new IllegalArgumentException("service not found with id " + serviceId));

    }

    // In ServiceService
    public List<Long> getAllServiceIdsByTenantId(Long tenantId) {
        return serviceRepository.findServiceIdsByTenantId(tenantId);
    }

}
