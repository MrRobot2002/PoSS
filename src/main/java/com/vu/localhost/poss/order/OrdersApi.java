package com.vu.localhost.poss.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@Validated
public interface OrdersApi {

        @Operation(summary = "Retrieve a list of all orders", description = "Endpoint to retrieve all orders with optional filters.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Order" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "A list of orders", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Order.class)))) })
        @RequestMapping(value = "/orders", produces = { "application/json" }, method = RequestMethod.GET)
        ResponseEntity<List<Order>> listOrders();

}
