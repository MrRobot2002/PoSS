package com.vu.localhost.poss.discount.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vu.localhost.poss.discount.model.Discount;
import com.vu.localhost.poss.discount.service.DiscountService;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DiscountApiController implements DiscountApi {

    private static final Logger log = LoggerFactory.getLogger(DiscountApiController.class);

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

    @Override
    public ResponseEntity<List<Discount>> listDiscounts() {
        try {
            List<Discount> discounts = discountService.getAllDiscounts();
            System.out.println("Discounts " + discounts);
            if (discounts.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(discounts);
        } catch (Exception e) {
            log.error("Error occurred while trying to list discounts: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
