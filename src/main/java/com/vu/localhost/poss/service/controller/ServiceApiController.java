package com.vu.localhost.poss.service.controller;

import com.vu.localhost.poss.tenant.model.Tenant;
import com.vu.localhost.poss.tenant.repository.TenantRepository;
import com.vu.localhost.poss.service.service.ServiceBookingService;
import com.vu.localhost.poss.service.service.ServiceService;
import com.vu.localhost.poss.common.ServiceBookingStatusEnum;
import com.vu.localhost.poss.employee.model.EmployeeAvailability;
import com.vu.localhost.poss.employee.service.EmployeeAvailabilityService;
import com.vu.localhost.poss.employee.service.EmployeeService;
import com.vu.localhost.poss.employee.service.EmployeeServicesService;
import com.vu.localhost.poss.service.model.ServiceRequestDTO;
import com.vu.localhost.poss.service.model.ServiceBookingRequestDTO;
import com.vu.localhost.poss.service.model.Service;
import com.vu.localhost.poss.service.model.ServiceBooking;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@RestController
public class ServiceApiController implements ServiceApi {

    private static final Logger logger = LoggerFactory.getLogger(ServiceApiController.class);

    private final ServiceBookingService bookingService;
    private final EmployeeAvailabilityService employeeAvailabilityService;
    private final EmployeeServicesService employeeServicesService;
    private final EmployeeService employeeService;
    private final ServiceService serviceService;
    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    public ServiceApiController(ServiceService serviceService, ServiceBookingService bookingService,
            EmployeeAvailabilityService employeeAvailabilityService, EmployeeServicesService employeeServicesService,
            EmployeeService employeeService) {
        this.serviceService = serviceService;
        this.bookingService = bookingService;
        this.employeeAvailabilityService = employeeAvailabilityService;
        this.employeeServicesService = employeeServicesService;
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<Service> createService(@RequestBody ServiceRequestDTO createServiceDTO) {
        Service service = convertServiceToEntity(createServiceDTO);
        Service createdService = serviceService.createService(service);
        return ResponseEntity.ok(createdService);
    }

    public ResponseEntity<ServiceBooking> createServiceBooking(@PathVariable("serviceId") Long serviceId,
            @RequestBody ServiceBookingRequestDTO serviceBookingRequestDTO) {
        ServiceBooking serviceBooking = convertBookingToEntity(serviceId, serviceBookingRequestDTO);
        ServiceBooking createdServiceBooking = bookingService.createServiceBooking(serviceBooking);
        return ResponseEntity.ok(createdServiceBooking);
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
            @RequestBody ServiceRequestDTO service) {
        try {
            Service updatedService = serviceService.updateService(id, service);
            return ResponseEntity.ok(updatedService);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> cancelServiceBooking(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId) {

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServiceBooking> getServiceBookingDetails(@PathVariable("bookingId") Long bookingId) {

        return bookingService.getServiceBookingById(bookingId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<Service>> listServices() {
        try {
            List<Service> services = serviceService.getAllServices();
            if (services.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(services);
        } catch (Exception e) {
            logger.debug("Error occurred while trying to list customers: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<List<ServiceBooking>> listServiceBookings(Long serviceId, Long customerId, Long employeeId,
            Boolean availability, LocalDateTime from,
            LocalDateTime to) {
        LocalDateTime startTime = (from != null) ? from : LocalDateTime.now();
        LocalDateTime endTime = (to != null) ? to : startTime.plusYears(1);

        List<Long> serviceIds = serviceId != null ? Collections.singletonList(serviceId)
                : serviceService.getAllServiceIdsByTenantId(1L);
        List<Long> employeeIds = employeeId != null ? Collections.singletonList(employeeId)
                : employeeService.getAllEmployeesIdsByTenantId(1L);

        List<ServiceBooking> existingBookings = bookingService.getBookingsForEmployees(employeeIds, startTime, endTime);
        List<ServiceBooking> potentialBookings = new ArrayList<>();

        // Generate potential bookings only if availability is true or null
        if (availability == null || availability) {
            List<EmployeeAvailability> availabilities = employeeAvailabilityService.getAvailabilities(startTime,
                    endTime, employeeIds);
            for (Long currentServiceId : serviceIds) {
                potentialBookings.addAll(
                        generatePotentialBookingsForService(availabilities, currentServiceId, existingBookings));
            }
        }

        List<ServiceBooking> combinedBookings = new ArrayList<>();
        if (availability == null) { // Include both potential and existing bookings if availability is null
            combinedBookings.addAll(potentialBookings);
            combinedBookings.addAll(existingBookings);
        } else if (availability) { // Include only potential bookings if availability is true
            combinedBookings.addAll(potentialBookings);
        } else { // Include only existing bookings if availability is false
            combinedBookings.addAll(existingBookings);
        }

        return ResponseEntity.ok(combinedBookings);
    }

    private List<ServiceBooking> generatePotentialBookingsForService(List<EmployeeAvailability> availabilities,
            Long serviceId, List<ServiceBooking> existingBookings) {
        List<ServiceBooking> potentialBookings = new ArrayList<>();
        Duration serviceDuration = Duration.ofMinutes(serviceService.getServiceDuration(serviceId));

        for (EmployeeAvailability availability : availabilities) {
            if (employeeServicesService.isEmployeeAssignedToService(availability.getEmployeeId(), serviceId)) {
                potentialBookings.addAll(
                        createBookingsForAvailability(availability, serviceId, serviceDuration, existingBookings));
            }
        }

        return potentialBookings;
    }

    private List<ServiceBooking> createBookingsForAvailability(EmployeeAvailability availability, Long serviceId,
            Duration serviceDuration, List<ServiceBooking> existingBookings) {
        List<ServiceBooking> bookings = new ArrayList<>();
        LocalDateTime slotStart = availability.getStartTime();

        while (slotStart.plus(serviceDuration).isBefore(availability.getEndTime())
                || slotStart.plus(serviceDuration).isEqual(availability.getEndTime())) {
            LocalDateTime slotEnd = slotStart.plus(serviceDuration);
            LocalDateTime finalSlotStart = slotStart;
            boolean isOverlapping = existingBookings.stream()
                    .anyMatch(booking -> finalSlotStart.isBefore(booking.getEndTime())
                            && slotEnd.isAfter(booking.getStartTime()));

            if (!isOverlapping) {
                ServiceBooking potentialBooking = new ServiceBooking();
                potentialBooking.setStartTime(slotStart);
                potentialBooking.setEndTime(slotEnd);
                potentialBooking.setEmployeeId(availability.getEmployeeId());
                potentialBooking.setServiceId(serviceId);
                potentialBooking.setServiceStatus(ServiceBookingStatusEnum.FREE);

                bookings.add(potentialBooking);
            }
            slotStart = slotEnd;
        }

        return bookings;
    }

    public ResponseEntity<ServiceBooking> updateServiceBooking(Long bookingId, ServiceBookingRequestDTO serviceBookingRequestDTO) {

        return bookingService.updateServiceBooking(bookingId, serviceBookingRequestDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @Transactional
    private Service convertServiceToEntity(ServiceRequestDTO createServiceDTO) {
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

    @Transactional
    private ServiceBooking convertBookingToEntity(Long serviceId, ServiceBookingRequestDTO serviceBookingRequestDTO) {
        ServiceBooking serviceBooking = new ServiceBooking();
        serviceBooking.setCustomerId(serviceBookingRequestDTO.getCustomerId());
        serviceBooking.setEmployeeId(serviceBookingRequestDTO.getEmployeeId());
        serviceBooking.setStartTime(serviceBookingRequestDTO.getBookingTimeStart());
        serviceBooking.setEndTime(serviceBookingRequestDTO.getBookingTimeEnd());
        serviceBooking.setServiceStatus(serviceBookingRequestDTO.getStatus());
        serviceBooking.setServiceId(serviceId);
        return serviceBooking;
    }

}
