package com.vu.localhost.poss.service.repository;

import com.vu.localhost.poss.service.model.ServiceBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ServiceBookingRepository extends JpaRepository<ServiceBooking, Long> {

    List<ServiceBooking> findByStartTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

    List<ServiceBooking> findAllByEmployeeIdInAndEndTimeBetween(List<Long> employeeIds, LocalDateTime startTime, LocalDateTime endTime);

    List<ServiceBooking> findAllByServiceIdInAndEmployeeIdInAndEndTimeBetween(List<Long> serviceIds, List<Long> employeeIds, LocalDateTime startTime, LocalDateTime endTime);

    List<ServiceBooking> findAllByServiceIdInAndCustomerIdAndEmployeeIdInAndEndTimeBetween(List<Long> serviceIds, Long customerId, List<Long> employeeIds, LocalDateTime startTime, LocalDateTime endTime);

}