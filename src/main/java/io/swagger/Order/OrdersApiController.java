package io.swagger.Order;

import io.swagger.Order.Order;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class OrdersApiController implements OrdersApi {

    private static final Logger log = LoggerFactory.getLogger(OrdersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OrdersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Order>> listOrders() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Order>>(objectMapper.readValue(
                        "[ {\n  \"orderId\" : 0,\n  \"employee_id\" : 1,\n  \"customer_id\" : 6,\n  \"items\" : [ {\n    \"itemId\" : 2,\n    \"quantity\" : 7,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\",\n    \"details\" : \"details\",\n    \"category\" : \"PRODUCT\"\n  }, {\n    \"itemId\" : 2,\n    \"quantity\" : 7,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\",\n    \"details\" : \"details\",\n    \"category\" : \"PRODUCT\"\n  } ],\n  \"tips\" : 5.637377,\n  \"discount_id\" : 5,\n  \"status\" : \"DONE\"\n}, {\n  \"orderId\" : 0,\n  \"employee_id\" : 1,\n  \"customer_id\" : 6,\n  \"items\" : [ {\n    \"itemId\" : 2,\n    \"quantity\" : 7,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\",\n    \"details\" : \"details\",\n    \"category\" : \"PRODUCT\"\n  }, {\n    \"itemId\" : 2,\n    \"quantity\" : 7,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\",\n    \"details\" : \"details\",\n    \"category\" : \"PRODUCT\"\n  } ],\n  \"tips\" : 5.637377,\n  \"discount_id\" : 5,\n  \"status\" : \"DONE\"\n} ]",
                        List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Order>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Order>>(HttpStatus.NOT_IMPLEMENTED);
    }

}