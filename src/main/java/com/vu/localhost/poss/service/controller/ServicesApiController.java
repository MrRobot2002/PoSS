package com.vu.localhost.poss.service.controller;

import com.vu.localhost.poss.employee.service.EmployeeService;
import com.vu.localhost.poss.service.model.CreateServiceBooking.StatusEnum;
import com.vu.localhost.poss.service.model.Service;
import com.vu.localhost.poss.service.service.ServiceService;
import com.vu.localhost.poss.employee.model.EmployeeAvailability;
import com.vu.localhost.poss.employee.service.EmployeeAvailabilityService;
import com.vu.localhost.poss.employee.service.EmployeeServicesService;
import com.vu.localhost.poss.service.model.ServiceBooking;
import com.vu.localhost.poss.service.service.ServiceBookingService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class ServicesApiController implements ServicesApi {

    private final ServiceService serviceService;
    private final ServiceBookingService bookingService;
    private final EmployeeAvailabilityService employeeAvailabilityService;
    private final EmployeeServicesService employeeServicesService;
    private final EmployeeService employeeService;

    @org.springframework.beans.factory.annotation.Autowired
    public ServicesApiController(ServiceService serviceService, ServiceBookingService bookingService,
            EmployeeAvailabilityService employeeAvailabilityService, EmployeeServicesService employeeServicesService,
            EmployeeService employeeService) {
        this.serviceService = serviceService;
        this.bookingService = bookingService;
        this.employeeAvailabilityService = employeeAvailabilityService;
        this.employeeServicesService = employeeServicesService;
        this.employeeService = employeeService;
    }

    public ResponseEntity<Void> cancelServiceBooking(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId) {

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServiceBooking> getServiceBookingDetails(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId) {

        return new ResponseEntity<ServiceBooking>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<Service>> listServices() {
        try {
            // Use the CustomerService to get all customers
            List<Service> services = serviceService.getAllServices();
            // Check if the customer list is empty
            if (services.isEmpty()) {
                // Return no content if there are no customers
                return ResponseEntity.noContent().build();
            }
            // Return the list of customers with an OK status
            return ResponseEntity.ok(services);
        } catch (Exception e) {
            // Log and return an Internal Server Error if something goes wrong
            System.err.println("Error occurred while trying to list customers: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // @Override
    // public ResponseEntity<List<ServiceBooking>> listServiceBookings(Long
    // serviceId, Long customerId, Long employeeId,
    // Boolean availability, LocalDateTime from,
    // LocalDateTime to) {
    // logger.info("listServiceBookings called with serviceId={}, customerId={},
    // employeeId={}, availability={}, from={}, to={}",
    // serviceId, customerId, employeeId, availability, from, to);
    //
    // LocalDateTime startTime = (from != null) ? from : LocalDateTime.now();
    // LocalDateTime endTime = (to != null) ? to : startTime.plusYears(1);
    //
    // logger.info("startTime={}, endTime={}", startTime, endTime);
    //
    //
    //
    // List<Long> serviceIds = serviceId != null ?
    // Collections.singletonList(serviceId) :
    // serviceService.getAllServiceIdsByTenantId(1L);
    //
    // logger.info("serviceIds={}", serviceIds);
    //
    // List<Long> employeeIds = employeeId != null ?
    // Collections.singletonList(employeeId) :
    // employeeService.getAllEmployeesIdsByTenantId(1L);
    //
    // logger.info("employeeIds={}", employeeIds);
    //
    // List<EmployeeAvailability> availabilities =
    // employeeAvailabilityService.getAvailabilities(startTime, endTime,
    // employeeIds);
    //
    // logger.info("availabilities={}", availabilities);
    //
    // List<ServiceBooking> potentialBookings = new ArrayList<>();
    // for (Long currentServiceId : serviceIds) {
    // List<ServiceBooking> bookingsForService =
    // generatePotentialBookingsForService(availabilities, currentServiceId);
    // potentialBookings.addAll(bookingsForService);
    // }
    //
    // logger.info("potentialBookings={}", potentialBookings);
    //
    // List<ServiceBooking> filteredBookings = filterBookings(potentialBookings,
    // availability, customerId);
    // return ResponseEntity.ok(filteredBookings);
    // }
    //
    // private List<ServiceBooking>
    // generatePotentialBookingsForService(List<EmployeeAvailability>
    // availabilities, Long serviceId) {
    // List<ServiceBooking> potentialBookings = new ArrayList<>();
    // Duration serviceDuration =
    // Duration.ofMinutes(serviceService.getServiceDuration(serviceId));
    //
    // for (EmployeeAvailability availability : availabilities) {
    // if
    // (employeeServicesService.isEmployeeAssignedToService(availability.getEmployeeId(),
    // serviceId)) {
    // potentialBookings.addAll(createBookingsForAvailability(availability,
    // serviceId, serviceDuration));
    // }
    // }
    //
    // return potentialBookings;
    // }
    //
    private List<ServiceBooking> filterBookings(List<ServiceBooking> bookings, Boolean availability, Long customerId) {
        return bookings.stream()
                .filter(booking -> (availability == null || isAvailabilityMatch(booking, availability)) &&
                        (customerId == null || booking.getCustomerId().equals(customerId)))
                .collect(Collectors.toList());
    }

    //
    private boolean isAvailabilityMatch(ServiceBooking booking, Boolean availability) {
        return availability ? booking.getServiceStatus() == StatusEnum.FREE.getOrdinal()
                : booking.getServiceStatus() != StatusEnum.FREE.getOrdinal();
    }
    //
    // private List<ServiceBooking>
    // createBookingsForAvailability(EmployeeAvailability availability, Long
    // serviceId, Duration serviceDuration) {
    // List<ServiceBooking> bookings = new ArrayList<>();
    // LocalDateTime slotStart = availability.getStartTime();
    //
    // while (slotStart.plus(serviceDuration).isBefore(availability.getEndTime()) ||
    // slotStart.plus(serviceDuration).isEqual(availability.getEndTime())) {
    // ServiceBooking potentialBooking = new ServiceBooking();
    // potentialBooking.setStartTime(slotStart);
    // potentialBooking.setEndTime(slotStart.plus(serviceDuration));
    // potentialBooking.setEmployeeId(availability.getEmployeeId());
    // potentialBooking.setServiceId(serviceId);
    // potentialBooking.setServiceStatus(StatusEnum.FREE.getOrdinal());
    //
    // bookings.add(potentialBooking);
    // slotStart = slotStart.plus(serviceDuration);
    // }
    //
    // return bookings;
    // }

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

        if (availability == false) {
            List<ServiceBooking> bookings = bookingService.getBookingsByFilter(serviceIds, customerId, employeeIds,
                    startTime, endTime);
            return ResponseEntity.ok(bookings);

        }

        List<EmployeeAvailability> availabilities = employeeAvailabilityService.getAvailabilities(startTime, endTime,
                employeeIds);
        List<ServiceBooking> existingBookings = bookingService.getBookingsForEmployees(employeeIds, startTime, endTime);

        List<ServiceBooking> potentialBookings = new ArrayList<>();
        for (Long currentServiceId : serviceIds) {
            List<ServiceBooking> bookingsForService = generatePotentialBookingsForService(availabilities,
                    currentServiceId, existingBookings);
            potentialBookings.addAll(bookingsForService);
        }

        List<ServiceBooking> filteredBookings = filterBookings(potentialBookings, availability, customerId);
        return ResponseEntity.ok(filteredBookings);
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
                potentialBooking.setServiceStatus(StatusEnum.FREE.getOrdinal());

                bookings.add(potentialBooking);
            }
            slotStart = slotEnd;
        }

        return bookings;
    }

    public ResponseEntity<Void> updateServiceBooking(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody ServiceBooking body) {

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}