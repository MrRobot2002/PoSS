package com.vu.localhost.poss.service.service;

import com.vu.localhost.poss.service.model.ServiceBooking;
import com.vu.localhost.poss.service.model.ServiceBookingRequestDTO;
import com.vu.localhost.poss.service.repository.ServiceBookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


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
            return serviceBookingRepository.findAllByServiceIdInAndEmployeeIdInAndStartTimeBetween(serviceIds, employeeIds, startTime, endTime);
        }

        return serviceBookingRepository.findAllByServiceIdInAndCustomerIdAndEmployeeIdInAndStartTimeBetween(serviceIds, customerId, employeeIds, startTime, endTime);
    }




    public List<ServiceBooking> getBookingsForEmployeesAndCustomer(List<Long> employeeIds, Long customerId, LocalDateTime startTime, LocalDateTime endTime) {


        if (customerId == null) {
            return serviceBookingRepository.findAllByEmployeeIdInAndStartTimeBetween(employeeIds, startTime, endTime);
        }
        return serviceBookingRepository.findAllByEmployeeIdInAndCustomerIdAndStartTimeBetween(employeeIds, customerId, startTime, endTime);

    }

    public Optional<ServiceBooking> getServiceBookingById(Long serviceId) {
        return serviceBookingRepository.findById(serviceId);
    }

    public List<ServiceBooking> getBookingsForEmployees(List<Long> employeeIds, LocalDateTime startTime,
                                                        LocalDateTime endTime) {

        return serviceBookingRepository.findAllByEmployeeIdInAndStartTimeBetween(employeeIds, startTime, endTime);

    }

    public ServiceBooking createServiceBooking(ServiceBooking serviceBooking) {
        return serviceBookingRepository.save(serviceBooking);
    }


    public Optional<ServiceBooking> updateServiceBooking(Long bookingId, ServiceBookingRequestDTO serviceBookingRequestDTO) {
        return serviceBookingRepository.findById(bookingId)
                .map(existingBooking -> {
                    updateExistingBooking(existingBooking, serviceBookingRequestDTO);
                    return serviceBookingRepository.save(existingBooking);
                });
    }


    public void deleteServiceBooking(Long serviceBookingId) {
        serviceBookingRepository.deleteById(serviceBookingId);
    }



    private void updateExistingBooking(ServiceBooking existingBooking, ServiceBookingRequestDTO serviceBookingRequestDTO) {
        existingBooking.setCustomerId(serviceBookingRequestDTO.getCustomerId());
        existingBooking.setEmployeeId(serviceBookingRequestDTO.getEmployeeId());
        existingBooking.setStartTime(serviceBookingRequestDTO.getBookingTimeStart());
        existingBooking.setEndTime(serviceBookingRequestDTO.getBookingTimeEnd());
        existingBooking.setServiceStatus(serviceBookingRequestDTO.getStatus());

    }
