package com.vu.localhost.poss.discount.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vu.localhost.poss.discount.model.Discount;

@Validated
public interface DiscountApi {

        @Operation(summary = "Retrieve details of a specific discount", description = "Endpoint to retrieve details of a specific discount by id.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "discount" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Detailed discount data", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Discount.class))),

                        @ApiResponse(responseCode = "404", description = "discount not found") })
        @RequestMapping(value = "/discount/{id}", produces = {
                        "application/json" }, method = RequestMethod.GET)
        ResponseEntity<Discount> getDiscount(
                        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("id") Long id);

        @Operation(summary = "Retrieve all available discounts", description = "Endpoint to retrieve all available discounts with optional query parameters for refined searching.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "discount" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "A list of available discounts", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Discount.class)))) })
        @RequestMapping(value = "/discounts", produces = { "application/json" }, method = RequestMethod.GET)
        ResponseEntity<List<Discount>> listDiscounts();

}
