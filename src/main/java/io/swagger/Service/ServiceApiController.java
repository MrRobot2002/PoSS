package io.swagger.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.Loyalty.LoyaltyRepository;
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
import org.springframework.beans.factory.annotation.Autowired;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class ServiceApiController implements ServiceApi {

    private final ServiceService serviceService;
    @Autowired
    private LoyaltyRepository loyaltyRepository;

    @Autowired
    public ServiceApiController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    public ResponseEntity<Void> createService(
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody CreateService body) {

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> createServiceBooking(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("serviceId") Long serviceId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody CreateServiceBooking body) {

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteService(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("serviceId") Long serviceId) {

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Service> getServiceDetails(@PathVariable("serviceId") Long id) {
        return serviceService.getServiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> updateService(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("serviceId") Long serviceId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Service body) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
