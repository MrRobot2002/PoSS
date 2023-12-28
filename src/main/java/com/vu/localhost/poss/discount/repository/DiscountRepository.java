package com.vu.localhost.poss.discount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vu.localhost.poss.discount.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

}