package com.vu.localhost.poss.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class DiscountApiController implements DiscountApi {

    private final DiscountService discountService;

    @Autowired
    public DiscountApiController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public ResponseEntity<Discount> getDiscount(@PathVariable("id") Long id) {
        return discountService.getDiscountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
