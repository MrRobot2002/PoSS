package com.vu.localhost.poss.service.repository;

import com.vu.localhost.poss.service.model.ServiceBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ServiceBookingRepository extends JpaRepository<ServiceBooking, Long> {

    List<ServiceBooking> findByStartTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

    List<ServiceBooking> findAllByEmployeeIdInAndStartTimeBetween(List<Long> employeeIds, LocalDateTime startTime,
                                                                  LocalDateTime endTime);

    List<ServiceBooking> findAllByServiceIdInAndEmployeeIdInAndStartTimeBetween(List<Long> serviceIds,
                                                                                List<Long> employeeIds, LocalDateTime startTime, LocalDateTime endTime);

    List<ServiceBooking> findAllByServiceIdInAndCustomerIdAndEmployeeIdInAndStartTimeBetween(List<Long> serviceIds,
                                                                                             Long customerId, List<Long> employeeIds, LocalDateTime startTime, LocalDateTime endTime);

    List<ServiceBooking> findAllByEmployeeIdInAndCustomerIdAndStartTimeBetween(List<Long> employeeIds, Long customerId, LocalDateTime startTime, LocalDateTime endTime);
}