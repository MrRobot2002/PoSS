package com.vu.localhost.poss.loyalty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vu.localhost.poss.loyalty.model.Loyalty;

public interface LoyaltyRepository extends JpaRepository<Loyalty, Long> {

}