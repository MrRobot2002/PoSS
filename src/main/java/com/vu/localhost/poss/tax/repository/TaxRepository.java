package com.vu.localhost.poss.tax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vu.localhost.poss.tax.model.Tax;

public interface TaxRepository extends JpaRepository<Tax, Long> {

}