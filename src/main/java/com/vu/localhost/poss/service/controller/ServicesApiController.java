package com.vu.localhost.poss.service.controller;

import com.vu.localhost.poss.service.service.ServiceService;
import com.vu.localhost.poss.service.model.Service;
import com.vu.localhost.poss.service.model.ServiceBooking;
import org.threeten.bp.OffsetDateTime;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class ServicesApiController implements ServicesApi {

    private final ServiceService serviceService;

    @org.springframework.beans.factory.annotation.Autowired
    public ServicesApiController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    public ResponseEntity<Void> cancelServiceBooking(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId) {

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServiceBooking> getServiceBookingDetails(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId) {

        return new ResponseEntity<ServiceBooking>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ServiceBooking>> listServiceBookings(
            @Parameter(in = ParameterIn.QUERY, description = "Unique identifier of the service", schema = @Schema()) @Valid @RequestParam(value = "serviceId", required = false) Long serviceId,
            @Parameter(in = ParameterIn.QUERY, description = "Unique identifier of the customer", schema = @Schema()) @Valid @RequestParam(value = "customerId", required = false) Long customerId,
            @Parameter(in = ParameterIn.QUERY, description = "Unique identifier of the employee", schema = @Schema()) @Valid @RequestParam(value = "employeeId", required = false) Long employeeId,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by availability", schema = @Schema()) @Valid @RequestParam(value = "availability", required = false) Boolean availability,
            @Parameter(in = ParameterIn.QUERY, description = "Start time for filtering bookings (inclusive)", schema = @Schema()) @Valid @RequestParam(value = "from", required = false) OffsetDateTime from,
            @Parameter(in = ParameterIn.QUERY, description = "End time for filtering bookings (inclusive)", schema = @Schema()) @Valid @RequestParam(value = "to", required = false) OffsetDateTime to) {

        return new ResponseEntity<List<ServiceBooking>>(HttpStatus.NOT_IMPLEMENTED);
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

    public ResponseEntity<Void> updateServiceBooking(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody ServiceBooking body) {

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
