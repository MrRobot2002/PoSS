/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.51).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.Product;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.List;

@Validated
public interface ProductsApi {

        @Operation(summary = "List all products in the inventory", description = "Retrieves a list of all products in the inventory.", security = {
                        @SecurityRequirement(name = "BearerAuth") }, tags = { "Product" })
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "A list of products in Inventory", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Product.class)))) })
        @RequestMapping(value = "/products", produces = { "application/json" }, method = RequestMethod.GET)
        ResponseEntity<List<Product>> listAllProducts(
                        @Parameter(in = ParameterIn.QUERY, description = "Page number (pagination)", schema = @Schema()) @Valid @RequestParam(value = "page", required = false) Integer page,
                        @Parameter(in = ParameterIn.QUERY, description = "Page size (pagination)", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit,
                        @Parameter(in = ParameterIn.QUERY, description = "Filter by price range (from 0, from 50 etc.)", schema = @Schema()) @Valid @RequestParam(value = "priceFrom", required = false) Double priceFrom,
                        @Parameter(in = ParameterIn.QUERY, description = "Filter by price range (to 50, to 100 etc.)", schema = @Schema()) @Valid @RequestParam(value = "priceTo", required = false) Double priceTo,
                        @Parameter(in = ParameterIn.QUERY, description = "Filter by stock level", schema = @Schema()) @Valid @RequestParam(value = "quantityFrom", required = false) Long quantityFrom,
                        @Parameter(in = ParameterIn.QUERY, description = "Filter by stock level", schema = @Schema()) @Valid @RequestParam(value = "quantityTo", required = false) Long quantityTo);
}