package io.swagger.Product;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class ProductsApiController implements ProductsApi {

    private static final Logger log = LoggerFactory.getLogger(ProductsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Product>> listAllProducts(
            @Parameter(in = ParameterIn.QUERY, description = "First element to show (pagination)", schema = @Schema()) @Valid @RequestParam(value = "from", required = false) Long from,
            @Parameter(in = ParameterIn.QUERY, description = "Last element to show (pagination)", schema = @Schema()) @Valid @RequestParam(value = "to", required = false) String to,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by price range (from 0, from 50 etc.)", schema = @Schema()) @Valid @RequestParam(value = "priceFrom", required = false) Long priceFrom,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by price range (to 50, to 100 etc.)", schema = @Schema()) @Valid @RequestParam(value = "priceTo", required = false) Long priceTo,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by stock level", schema = @Schema()) @Valid @RequestParam(value = "quantityFrom", required = false) Long quantityFrom,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by stock level", schema = @Schema()) @Valid @RequestParam(value = "quantityTo", required = false) Long quantityTo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Product>>(objectMapper.readValue(
                        "[ {\n  \"quantity\" : 6,\n  \"productId\" : 0,\n  \"price\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"name\" : \"name\"\n}, {\n  \"quantity\" : 6,\n  \"productId\" : 0,\n  \"price\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"name\" : \"name\"\n} ]",
                        List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Product>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
