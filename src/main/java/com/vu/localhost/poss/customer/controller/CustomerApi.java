package com.vu.localhost.poss.customer.controller;

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

import com.vu.localhost.poss.customer.model.CustomerRequestDTO;
import com.vu.localhost.poss.customer.model.Customer;

import java.util.List;

import javax.validation.Valid;

@Validated
public interface CustomerApi {

        @Operation(summary = "Create a new customer", description = "Creates a new customer in the POS system.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "customer" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "customer created successfully"),

                        @ApiResponse(responseCode = "400", description = "Invalid input") })
        @RequestMapping(value = "/customer", consumes = { "application/json" }, method = RequestMethod.POST)
        ResponseEntity<Customer> createCustomer(
                        @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody CustomerRequestDTO body);

        @Operation(summary = "Remove a customer", description = "Removes a customer from the POS system.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "customer" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "customer removed successfully"),

                        @ApiResponse(responseCode = "404", description = "customer not found") })
        @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.DELETE)
        ResponseEntity<Void> deleteCustomer(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("customerId") Long customerId);

        @Operation(summary = "Retrieve details of a specific customer", description = "Retrieves details of a specific customer by ID.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "customer" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "customer details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))),

                        @ApiResponse(responseCode = "404", description = "customer not found") })
        @RequestMapping(value = "/customer/{customerId}", produces = { "application/json" }, method = RequestMethod.GET)
        ResponseEntity<Customer> getCustomer(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("customerId") Long customerId);

        @Operation(summary = "Update a customers's details", description = "Updates a customers's details, including their role.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "customer" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "customer updated successfully"),

                        @ApiResponse(responseCode = "400", description = "Invalid input"),

                        @ApiResponse(responseCode = "404", description = "customer not found") })
        @RequestMapping(value = "/customer/{customerId}", consumes = { "application/json" }, method = RequestMethod.PUT)
        ResponseEntity<Customer> updateCustomer(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("customerId") Long customerId,
                        @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody CustomerRequestDTO body);

        @Operation(summary = "List all customers", description = "Retrieves a list of all customers in the POS system.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "customer" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "A list of customers", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Customer.class)))) })
        @RequestMapping(value = "/customers", produces = { "application/json" }, method = RequestMethod.GET)
        ResponseEntity<List<Customer>> listCustomers();

}
