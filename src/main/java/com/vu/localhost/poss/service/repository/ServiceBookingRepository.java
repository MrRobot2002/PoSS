package com.vu.localhost.poss.service.repository;

import com.vu.localhost.poss.service.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceBookingRepository extends JpaRepository<Service, Long> {

}