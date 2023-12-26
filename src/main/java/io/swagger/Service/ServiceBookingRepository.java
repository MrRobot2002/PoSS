package io.swagger.Service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceBookingRepository extends JpaRepository<Service, Long> {

}