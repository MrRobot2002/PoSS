package io.swagger.api;

import io.swagger.model.Discount;
import io.swagger.model.Order;
import io.swagger.model.OrderItem;
import io.swagger.model.Payment;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-07T03:52:36.392108+02:00[Europe/Vilnius]")
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

    public ResponseEntity<Void> addProductToOrder(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("orderID") Long orderID
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody OrderItem body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> applyDiscount(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("orderID") Long orderID
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Discount body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Order> createOrder(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Order body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Order>(objectMapper.readValue("{\n  \"orderId\" : 0,\n  \"items\" : [ {\n    \"itemId\" : 6,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\"\n  }, {\n    \"itemId\" : 6,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\"\n  } ],\n  \"status\" : \"DONE\"\n}", Order.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteOrder(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("orderID") Long orderID
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Order> getOrder(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("orderID") Long orderID
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Order>(objectMapper.readValue("{\n  \"orderId\" : 0,\n  \"items\" : [ {\n    \"itemId\" : 6,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\"\n  }, {\n    \"itemId\" : 6,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\"\n  } ],\n  \"status\" : \"DONE\"\n}", Order.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Order>> listOrders(@Parameter(in = ParameterIn.QUERY, description = "Optional category filer for Orders." ,schema=@Schema()) @Valid @RequestParam(value = "category", required = false) String category
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Order>>(objectMapper.readValue("[ {\n  \"orderId\" : 0,\n  \"items\" : [ {\n    \"itemId\" : 6,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\"\n  }, {\n    \"itemId\" : 6,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\"\n  } ],\n  \"status\" : \"DONE\"\n}, {\n  \"orderId\" : 0,\n  \"items\" : [ {\n    \"itemId\" : 6,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\"\n  }, {\n    \"itemId\" : 6,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\"\n  } ],\n  \"status\" : \"DONE\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Order>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Order>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyProductQuantityInOrder(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("orderID") Long orderID
,@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("productID") Long productID
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody OrderItem body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> payForOrder(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("orderID") Long orderID
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Payment body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> removeProductFromOrder(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("orderID") Long orderID
,@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("productID") Long productID
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateOrder(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("orderID") Long orderID
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Order body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
