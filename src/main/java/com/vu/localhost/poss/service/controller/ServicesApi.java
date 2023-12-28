package com.vu.localhost.poss.service.controller;
import com.vu.localhost.poss.service.model.ServiceBooking;
import com.vu.localhost.poss.service.model.Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@Validated
public interface ServicesApi {

        @Operation(summary = "Cancel a service booking", description = "Cancels a specific service booking.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Booking" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "Booking cancelled"),

                        @ApiResponse(responseCode = "404", description = "Booking not found") })
        @RequestMapping(value = "/services/booking/{bookingId}", method = RequestMethod.DELETE)
        ResponseEntity<Void> cancelServiceBooking(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId);

        @Operation(summary = "Retrieve details of a specific booking", description = "Retrieves details of a specific service booking.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Booking" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Booking details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceBooking.class))),

                        @ApiResponse(responseCode = "404", description = "Booking not found") })
        @RequestMapping(value = "/services/booking/{bookingId}", produces = {
                        "application/json" }, method = RequestMethod.GET)
        ResponseEntity<ServiceBooking> getServiceBookingDetails(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId);

        @Operation(summary = "List all bookings for a specific or non specific service within a time range", description = "Retrieves a list of all bookings for a specific or non specific service, optionally filtered by a time range.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Booking" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "List of service bookings within the specified time range", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ServiceBooking.class)))),

                        @ApiResponse(responseCode = "404", description = "service not found") })
        @RequestMapping(value = "/services/bookings", produces = { "application/json" }, method = RequestMethod.GET)
        ResponseEntity<List<ServiceBooking>> listServiceBookings(
                        @Parameter(in = ParameterIn.QUERY, description = "Unique identifier of the service", schema = @Schema()) @Valid @RequestParam(value = "serviceId", required = false) Long serviceId,
                        @Parameter(in = ParameterIn.QUERY, description = "Unique identifier of the customer", schema = @Schema()) @Valid @RequestParam(value = "customerId", required = false) Long customerId,
                        @Parameter(in = ParameterIn.QUERY, description = "Unique identifier of the Employee", schema = @Schema()) @Valid @RequestParam(value = "employeeId", required = false) Long employeeId,
                        @Parameter(in = ParameterIn.QUERY, description = "Filter by availability", schema = @Schema()) @Valid @RequestParam(value = "availability", required = false) Boolean availability,
                        @Parameter(in = ParameterIn.QUERY, description = "Start time for filtering bookings (inclusive)", schema = @Schema()) @Valid @RequestParam(value = "from", required = false) LocalDateTime from,
                        @Parameter(in = ParameterIn.QUERY, description = "End time for filtering bookings (inclusive)", schema = @Schema()) @Valid @RequestParam(value = "to", required = false) LocalDateTime to);

        @Operation(summary = "Retrieve a list of all service offered", description = "Retrieves a list of all service offered by the POS system.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "service" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "A list of service", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Service.class)))) })
        @RequestMapping(value = "/services", produces = { "application/json" }, method = RequestMethod.GET)
        ResponseEntity<List<Service>> listServices();


    @Operation(summary = "Update a service booking", description = "Updates details of an existing service booking.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Booking" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Booking updated"),

                        @ApiResponse(responseCode = "400", description = "Invalid input"),

                        @ApiResponse(responseCode = "404", description = "Booking not found") })
        @RequestMapping(value = "/services/booking/{bookingId}", consumes = {
                        "application/json" }, method = RequestMethod.PUT)
        ResponseEntity<Void> updateServiceBooking(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId,
                        @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody ServiceBooking body);

}
