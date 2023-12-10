package io.swagger.api;

import io.swagger.model.Product;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-10T17:29:46.806586+02:00[Europe/Vilnius]")
@RestController
public class InventoryApiController implements InventoryApi {

    private static final Logger log = LoggerFactory.getLogger(InventoryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public InventoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Product> addProduct(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Product body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Product>(objectMapper.readValue("{\n  \"productId\" : \"productId\",\n  \"price\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"name\" : \"name\",\n  \"stockLevel\" : 0\n}", Product.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteProduct(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("productId") Long productId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Product> getProduct(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("productId") Long productId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Product>(objectMapper.readValue("{\n  \"productId\" : \"productId\",\n  \"price\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"name\" : \"name\",\n  \"stockLevel\" : 0\n}", Product.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Product>> listAllProducts(@Parameter(in = ParameterIn.QUERY, description = "Filter by product category" ,schema=@Schema()) @Valid @RequestParam(value = "category", required = false) String category
,@Parameter(in = ParameterIn.QUERY, description = "Filter by price range (0-50, 50-100 etc.)" ,schema=@Schema()) @Valid @RequestParam(value = "priceRange", required = false) String priceRange
,@Parameter(in = ParameterIn.QUERY, description = "Filter by stock level" ,schema=@Schema()) @Valid @RequestParam(value = "stockLevel", required = false) Integer stockLevel
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Product>>(objectMapper.readValue("[ {\n  \"productId\" : \"productId\",\n  \"price\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"name\" : \"name\",\n  \"stockLevel\" : 0\n}, {\n  \"productId\" : \"productId\",\n  \"price\" : {\n    \"amount\" : 6.0274563,\n    \"currency\" : \"EUR\"\n  },\n  \"name\" : \"name\",\n  \"stockLevel\" : 0\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Product>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> patchProduct(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("productId") Long productId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Product body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateProduct(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("productId") Long productId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Product body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
