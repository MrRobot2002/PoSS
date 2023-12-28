package com.vu.localhost.poss.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vu.localhost.poss.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}