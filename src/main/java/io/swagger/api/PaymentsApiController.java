package io.swagger.api;

import io.swagger.model.PaymentDetail;
import io.swagger.model.PaymentRequest;
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
public class PaymentsApiController implements PaymentsApi {

    private static final Logger log = LoggerFactory.getLogger(PaymentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PaymentsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<PaymentDetail> createPayment(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody PaymentRequest body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PaymentDetail>(objectMapper.readValue("{\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"amount\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"orderId\" : 0,\n  \"paymentId\" : \"paymentId\",\n  \"paymentState\" : \"NULL\",\n  \"paymentType\" : \"CARD\"\n}", PaymentDetail.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PaymentDetail>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PaymentDetail>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deletePayment(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("paymentId") String paymentId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<PaymentDetail> getPaymentDetail(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("paymentId") String paymentId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PaymentDetail>(objectMapper.readValue("{\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"amount\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"orderId\" : 0,\n  \"paymentId\" : \"paymentId\",\n  \"paymentState\" : \"NULL\",\n  \"paymentType\" : \"CARD\"\n}", PaymentDetail.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PaymentDetail>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PaymentDetail>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<PaymentDetail>> listPayments(@Parameter(in = ParameterIn.QUERY, description = "Filter by payment type (CARD, CASH, COUPON)" ,schema=@Schema()) @Valid @RequestParam(value = "paymentType", required = false) String paymentType
,@Parameter(in = ParameterIn.QUERY, description = "Filter by payment state (NULL, PENDING, PARTIALLY_PAID, PAID)" ,schema=@Schema()) @Valid @RequestParam(value = "paymentState", required = false) String paymentState
,@Parameter(in = ParameterIn.QUERY, description = "Filter by payment date range" ,schema=@Schema()) @Valid @RequestParam(value = "dateRange", required = false) String dateRange
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<PaymentDetail>>(objectMapper.readValue("[ {\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"amount\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"orderId\" : 0,\n  \"paymentId\" : \"paymentId\",\n  \"paymentState\" : \"NULL\",\n  \"paymentType\" : \"CARD\"\n}, {\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"amount\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"orderId\" : 0,\n  \"paymentId\" : \"paymentId\",\n  \"paymentState\" : \"NULL\",\n  \"paymentType\" : \"CARD\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<PaymentDetail>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<PaymentDetail>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updatePayment(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("paymentId") String paymentId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody PaymentRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
