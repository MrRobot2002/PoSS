package io.swagger.Order;

import io.swagger.model.CreateOrder;
import io.swagger.Item.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class OrderApiController implements OrderApi {

    private static final Logger log = LoggerFactory.getLogger(OrderApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OrderApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addItemToOrder(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Item body) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Order> createOrder(
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody CreateOrder body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Order>(objectMapper.readValue(
                        "{\n  \"orderId\" : 0,\n  \"employee_id\" : 1,\n  \"customer_id\" : 6,\n  \"items\" : [ {\n    \"itemId\" : 2,\n    \"quantity\" : 7,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\",\n    \"details\" : \"details\",\n    \"category\" : \"PRODUCT\"\n  }, {\n    \"itemId\" : 2,\n    \"quantity\" : 7,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\",\n    \"details\" : \"details\",\n    \"category\" : \"PRODUCT\"\n  } ],\n  \"tips\" : 5.637377,\n  \"discount_id\" : 5,\n  \"status\" : \"DONE\"\n}",
                        Order.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteOrder(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Order> getOrder(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Order>(objectMapper.readValue(
                        "{\n  \"orderId\" : 0,\n  \"employee_id\" : 1,\n  \"customer_id\" : 6,\n  \"items\" : [ {\n    \"itemId\" : 2,\n    \"quantity\" : 7,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\",\n    \"details\" : \"details\",\n    \"category\" : \"PRODUCT\"\n  }, {\n    \"itemId\" : 2,\n    \"quantity\" : 7,\n    \"price\" : {\n      \"amount\" : 6.0274563,\n      \"currency\" : \"EUR\"\n    },\n    \"name\" : \"name\",\n    \"details\" : \"details\",\n    \"category\" : \"PRODUCT\"\n  } ],\n  \"tips\" : 5.637377,\n  \"discount_id\" : 5,\n  \"status\" : \"DONE\"\n}",
                        Order.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyItemQuantityInOrder(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID,
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema(allowableValues = {
                    "PRODUCT", "SERVICE" })) @PathVariable("category") String category,
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("itemID") Long itemID,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Item body) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> removeItemFromOrder(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID,
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema(allowableValues = {
                    "PRODUCT", "SERVICE" })) @PathVariable("category") String category,
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("itemID") Long itemID) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateOrder(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Order body) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
