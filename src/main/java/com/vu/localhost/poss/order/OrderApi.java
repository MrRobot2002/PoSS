package com.vu.localhost.poss.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vu.localhost.poss.orderItem.OrderItem;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@Validated
public interface OrderApi {

        @Operation(summary = "Add an item to an order", description = "Endpoint to add a product to an order by ID.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Order" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Product added to order"),

                        @ApiResponse(responseCode = "400", description = "Invalid input"),

                        @ApiResponse(responseCode = "404", description = "Order not found") })
        @RequestMapping(value = "/order/{orderID}/item", consumes = { "application/json" }, method = RequestMethod.POST)
        ResponseEntity<Void> addItemToOrder(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID,
                        @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody OrderItem body);

        @Operation(summary = "Create a new order", description = "Endpoint to create a new order.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Order" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Order successfully created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class))),

                        @ApiResponse(responseCode = "400", description = "Invalid input") })
        @RequestMapping(value = "/order", produces = { "application/json" }, consumes = {
                        "application/json" }, method = RequestMethod.POST)
        ResponseEntity<Order> createOrder(
                        @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody OrderRequestDTO body);

        @Operation(summary = "Delete an existing order", description = "Endpoint to delete an existing order by ID.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Order" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "Order successfully deleted"),

                        @ApiResponse(responseCode = "404", description = "Order not found") })
        @RequestMapping(value = "/order/{orderID}", method = RequestMethod.DELETE)
        ResponseEntity<Void> deleteOrder(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID);

        @Operation(summary = "Retrieve details of a specific order", description = "Endpoint to retrieve details of a specific order by ID.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Order" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Detailed order data", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class))),

                        @ApiResponse(responseCode = "404", description = "Order not found") })
        @RequestMapping(value = "/order/{orderID}", produces = { "application/json" }, method = RequestMethod.GET)
        ResponseEntity<OrderResponseDTO> getOrder(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID);

        @Operation(summary = "Modify the quantity of a item in an order", description = "Endpoint to modify the quantity of an item in an order by ID.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Order" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Item quantity modified"),

                        @ApiResponse(responseCode = "400", description = "Invalid input"),

                        @ApiResponse(responseCode = "404", description = "Order or item not found") })
        @RequestMapping(value = "/order/{orderID}/item/{itemID}", consumes = {
                        "application/json" }, method = RequestMethod.PUT)
        ResponseEntity<Void> modifyItemQuantityInOrder(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID,
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("itemID") Long itemID,
                        @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody OrderItem body);

        @Operation(summary = "Remove an item from an order", description = "Endpoint to remove an item from an order by ID.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Order" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "Item removed from order"),

                        @ApiResponse(responseCode = "404", description = "Order or item not found") })
        @RequestMapping(value = "/order/{orderID}/item/{itemID}", method = RequestMethod.DELETE)
        ResponseEntity<Void> removeItemFromOrder(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID,
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("itemID") Long itemID);

        @Operation(summary = "Update an existing order", description = "Endpoint to update an existing order by ID.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Order" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Order successfully updated"),

                        @ApiResponse(responseCode = "400", description = "Invalid input"),

                        @ApiResponse(responseCode = "404", description = "Order not found") })
        @RequestMapping(value = "/order/{orderID}", consumes = { "application/json" }, method = RequestMethod.PUT)
        ResponseEntity<Order> updateOrder(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID,
                        @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody OrderRequestDTO body);

}
