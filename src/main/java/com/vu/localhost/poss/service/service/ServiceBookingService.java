package com.vu.localhost.poss.service.service;

import com.vu.localhost.poss.service.model.ServiceBooking;
import com.vu.localhost.poss.service.repository.ServiceBookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceBookingService {
    private final ServiceBookingRepository serviceBookingRepository;

    public ServiceBookingService(ServiceBookingRepository serviceBookingRepository) {
        this.serviceBookingRepository = serviceBookingRepository;
    }

    public List<ServiceBooking> getBookingsByDateRange(LocalDateTime startTime, LocalDateTime endTime) {
        return serviceBookingRepository.findByStartTimeBetween(startTime, endTime);
    }

    public List<ServiceBooking> getBookingsByFilter(List<Long> serviceIds, Long customerId, List<Long> employeeIds,
            LocalDateTime startTime, LocalDateTime endTime) {

        if (customerId == null) {
            return serviceBookingRepository.findAllByServiceIdInAndEmployeeIdInAndEndTimeBetween(serviceIds,
                    employeeIds, startTime, endTime);
        }

        return serviceBookingRepository.findAllByServiceIdInAndCustomerIdAndEmployeeIdInAndEndTimeBetween(serviceIds,
                customerId, employeeIds, startTime, endTime);
    }

    public List<ServiceBooking> getBookingsForEmployees(List<Long> employeeIds, LocalDateTime startTime,
            LocalDateTime endTime) {

        return serviceBookingRepository.findAllByEmployeeIdInAndEndTimeBetween(employeeIds, startTime, endTime);

    }

    public ServiceBooking createServiceBooking(ServiceBooking serviceBooking) {
        return serviceBookingRepository.save(serviceBooking);
    }

    public void deleteServiceBooking(Long serviceBookingId) {
        serviceBookingRepository.deleteById(serviceBookingId);
    }

    public Optional<ServiceBooking> getServiceBookingById(Long serviceId) {
        return serviceBookingRepository.findById(serviceId);
    }

}
