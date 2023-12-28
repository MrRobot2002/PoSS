package com.vu.localhost.poss.service.controller;

import com.vu.localhost.poss.tenant.Tenant;
import com.vu.localhost.poss.tenant.TenantRepository;
import com.vu.localhost.poss.service.service.ServiceService;
import com.vu.localhost.poss.service.model.CreateService;
import com.vu.localhost.poss.service.model.CreateServiceBooking;
import com.vu.localhost.poss.service.model.Service;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class ServiceApiController implements ServiceApi {

    private final ServiceService serviceService;
    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    public ServiceApiController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @Override
    public ResponseEntity<Service> createService(@RequestBody CreateService createServiceDTO) {
        Service service = convertToEntity(createServiceDTO);
        Service createdService = serviceService.createService(service);
        return ResponseEntity.ok(createdService);
    }

    public ResponseEntity<Void> createServiceBooking(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("serviceId") Long serviceId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody CreateServiceBooking body) {

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> deleteService(Long serviceId) {
        try {
            // Call the service to delete the service by ID
            serviceService.deleteService(serviceId);

            // Return an appropriate response
            // HttpStatus.NO_CONTENT indicates that the action was successful but there's no
            // content to return.
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            // If the service doesn't exist, you might want to return a 404 Not Found.
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // For other exceptions, you might return a 500 Internal Server Error
            // Log the exception for debugging purposes
            // (Make sure to import the necessary Logger at the beginning of your class)
            System.err.println("Error occurred while trying to delete service: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Service> getServiceDetails(@PathVariable("serviceId") Long id) {
        return serviceService.getServiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Service> updateService(@PathVariable("serviceId") Long id,
            @RequestBody CreateService service) {
        try {
            Service updatedService = serviceService.updateService(id, service);
            return ResponseEntity.ok(updatedService);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    private Service convertToEntity(CreateService createServiceDTO) {
        Service service = new Service();
        service.setName(createServiceDTO.getName());
        service.setDuration(createServiceDTO.getDuration());
        service.setDescription(createServiceDTO.getDescription());
        service.setPrice(createServiceDTO.getPrice());

        if (createServiceDTO.getTenant() != null) {
            Tenant tenant = tenantRepository.findById(createServiceDTO.getTenant())
                    .orElseThrow(() -> new EntityNotFoundException("tenant not found"));
            service.setTenant(tenant.getId());
        }

        return service;
    }

}
