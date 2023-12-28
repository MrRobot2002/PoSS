package com.vu.localhost.poss.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    // Retrieve a single discount by ID
    public Optional<Discount> getDiscountById(Long discountId) {
        Discount c = discountRepository.findById(discountId).get();
        System.out.println(discountId);
        return discountRepository.findById(discountId);
    }

    // Retrieve all discounts
    public List<Discount> getAllDiscounts() {
        System.out.println("service Discounts " + discountRepository.findAll());
        return discountRepository.findAll();
    }
}
