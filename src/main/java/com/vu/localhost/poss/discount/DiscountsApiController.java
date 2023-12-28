package com.vu.localhost.poss.discount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class DiscountsApiController implements DiscountsApi {

    private static final Logger log = LoggerFactory.getLogger(DiscountsApiController.class);

    private final DiscountService discountService;

    @org.springframework.beans.factory.annotation.Autowired
    public DiscountsApiController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public ResponseEntity<List<Discount>> listDiscounts() {
        try {
            // Use the DiscountService to get all discounts
            List<Discount> discounts = discountService.getAllDiscounts();
            System.out.println("Discounts " + discounts);
            // Check if the discount list is empty
            if (discounts.isEmpty()) {
                // Return no content if there are no discounts
                return ResponseEntity.noContent().build();
            }

            // Return the list of discounts with an OK status
            return ResponseEntity.ok(discounts);
        } catch (Exception e) {
            // Log and return an Internal Server Error if something goes wrong
            log.error("Error occurred while trying to list discounts: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
