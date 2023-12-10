package io.swagger.api;

import org.threeten.bp.OffsetDateTime;
import io.swagger.model.Service;
import io.swagger.model.ServiceBooking;
import io.swagger.model.ServiceDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-10T17:29:46.806586+02:00[Europe/Vilnius]")
@RestController
public class ServicesApiController implements ServicesApi {

    private static final Logger log = LoggerFactory.getLogger(ServicesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ServicesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> cancelServiceBooking(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("bookingId") Long bookingId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> createService(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Service body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> createServiceBooking(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("serviceId") Long serviceId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ServiceBooking body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteService(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("serviceId") Long serviceId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ServiceBooking>> getCustomerBookings(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Unique identifier of the customer" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "customerId", required = true) Long customerId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ServiceBooking>>(objectMapper.readValue("[ {\n  \"bookingTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"customerId\" : 1,\n  \"employeeId\" : 5,\n  \"serviceId\" : 6,\n  \"bookingId\" : 0,\n  \"status\" : \"SCHEDULED\"\n}, {\n  \"bookingTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"customerId\" : 1,\n  \"employeeId\" : 5,\n  \"serviceId\" : 6,\n  \"bookingId\" : 0,\n  \"status\" : \"SCHEDULED\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ServiceBooking>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ServiceBooking>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ServiceBooking>> getEmployeeBookings(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Unique identifier of the employee" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "employeeId", required = true) Long employeeId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ServiceBooking>>(objectMapper.readValue("[ {\n  \"bookingTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"customerId\" : 1,\n  \"employeeId\" : 5,\n  \"serviceId\" : 6,\n  \"bookingId\" : 0,\n  \"status\" : \"SCHEDULED\"\n}, {\n  \"bookingTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"customerId\" : 1,\n  \"employeeId\" : 5,\n  \"serviceId\" : 6,\n  \"bookingId\" : 0,\n  \"status\" : \"SCHEDULED\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ServiceBooking>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ServiceBooking>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServiceBooking> getServiceBookingDetails(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("bookingId") Long bookingId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServiceBooking>(objectMapper.readValue("{\n  \"bookingTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"customerId\" : 1,\n  \"employeeId\" : 5,\n  \"serviceId\" : 6,\n  \"bookingId\" : 0,\n  \"status\" : \"SCHEDULED\"\n}", ServiceBooking.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServiceBooking>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServiceBooking>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServiceDetails> getServiceDetails(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("serviceId") Long serviceId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServiceDetails>(objectMapper.readValue("{\n  \"price\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"name\" : \"name\",\n  \"description\" : \"description\",\n  \"availability\" : true,\n  \"serviceId\" : 0\n}", ServiceDetails.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServiceDetails>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServiceDetails>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ServiceBooking>> listServiceBookings(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Unique identifier of the service" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "serviceId", required = true) Long serviceId
,@Parameter(in = ParameterIn.QUERY, description = "Start time for filtering bookings (inclusive)" ,schema=@Schema()) @Valid @RequestParam(value = "startTime", required = false) OffsetDateTime startTime
,@Parameter(in = ParameterIn.QUERY, description = "End time for filtering bookings (inclusive)" ,schema=@Schema()) @Valid @RequestParam(value = "endTime", required = false) OffsetDateTime endTime
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ServiceBooking>>(objectMapper.readValue("[ {\n  \"bookingTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"customerId\" : 1,\n  \"employeeId\" : 5,\n  \"serviceId\" : 6,\n  \"bookingId\" : 0,\n  \"status\" : \"SCHEDULED\"\n}, {\n  \"bookingTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"customerId\" : 1,\n  \"employeeId\" : 5,\n  \"serviceId\" : 6,\n  \"bookingId\" : 0,\n  \"status\" : \"SCHEDULED\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ServiceBooking>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ServiceBooking>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Service>> listServices() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Service>>(objectMapper.readValue("[ {\n  \"price\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"name\" : \"name\",\n  \"description\" : \"description\",\n  \"serviceId\" : \"serviceId\"\n}, {\n  \"price\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"name\" : \"name\",\n  \"description\" : \"description\",\n  \"serviceId\" : \"serviceId\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Service>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Service>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateService(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("serviceId") Long serviceId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Service body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateServiceBooking(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("bookingId") Long bookingId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ServiceBooking body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
