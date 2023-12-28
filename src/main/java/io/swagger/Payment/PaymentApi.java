package io.swagger.Payment;

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
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import javax.validation.Valid;

@Validated
public interface PaymentApi {

    @Operation(summary = "Create a new payment record", description = "Allows the creation of a new payment.", security = {
            @SecurityRequirement(name = "BearerAuth") }, tags = { "Payment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Payment.class))),

            @ApiResponse(responseCode = "400", description = "Invalid input") })
    @RequestMapping(value = "/payment", produces = { "application/json" }, consumes = {
            "application/json" }, method = RequestMethod.POST)
    ResponseEntity<Payment> createPayment(
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody PaymentRequestDTO body);

    @Operation(summary = "Delete a payment record", description = "Deletes a specific payment record by ID.", security = {
            @SecurityRequirement(name = "BearerAuth") }, tags = { "Payment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted"),

            @ApiResponse(responseCode = "404", description = "Payment not found") })
    @RequestMapping(value = "/payment/{paymentId}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePayment(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("paymentId") String paymentId);

    @Operation(summary = "Retrieve details of a specific payment", description = "Retrieves details of a specific payment by ID.", security = {
            @SecurityRequirement(name = "BearerAuth") }, tags = { "Payment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Payment.class))),

            @ApiResponse(responseCode = "404", description = "Payment not found") })
    @RequestMapping(value = "/payment/{paymentId}", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<Payment> getPaymentDetails(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("paymentId") String paymentId);

    @Operation(summary = "List all payment records", description = "Retrieves a list of all payments.", security = {
            @SecurityRequirement(name = "BearerAuth") }, tags = { "Payment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A list of payments", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Payment.class)))) })
    @RequestMapping(value = "/payments", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<List<Payment>> listPayments(
            @Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "orderId", required = false) Long orderId,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by payment type (CARD, CASH, COUPON)", schema = @Schema()) @Valid @RequestParam(value = "paymentType", required = false) Integer paymentType,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by payment state (NULL, PENDING, PARTIALLY_PAID, PAID)", schema = @Schema()) @Valid @RequestParam(value = "paymentState", required = false) Integer paymentState,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by payment date range", schema = @Schema()) @Valid @RequestParam(value = "dateRangeStart", required = false) String dateRangeStart,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by payment date range", schema = @Schema()) @Valid @RequestParam(value = "dateRangeEnd", required = false) String dateRangeEnd,
            @Parameter(in = ParameterIn.QUERY, description = "Page number for pagination", schema = @Schema()) @Valid @RequestParam(value = "page", required = false) Integer page,
            @Parameter(in = ParameterIn.QUERY, description = "Page size for pagination", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit);

}
