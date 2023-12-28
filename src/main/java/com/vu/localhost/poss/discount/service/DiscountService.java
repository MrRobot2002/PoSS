package com.vu.localhost.poss.discount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vu.localhost.poss.discount.model.Discount;
import com.vu.localhost.poss.discount.repository.DiscountRepository;

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
        return discountRepository.findById(discountId);
    }

    // Retrieve all discounts
    public List<Discount> getAllDiscounts() {
        System.out.println("service Discounts " + discountRepository.findAll());
        return discountRepository.findAll();
    }
}
