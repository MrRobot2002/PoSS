package com.vu.localhost.poss.service.model;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Booking")
public class ServiceBooking {

    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "start_time", nullable = false)
  private LocalDateTime startTime;

  @Column(name = "end_time", nullable = false)
  private LocalDateTime endTime;

  @Column(name = "employee_id", nullable = false)
  private Long employeeId;

  @Column(name = "service_status", nullable = false)
  private Long serviceStatus;

  @Column(name = "customer_id", nullable = false)
  private Long customerId;

  @Column(name = "service_id", nullable = false)
  private Long serviceId;

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public Long getServiceStatus() {
    return serviceStatus;
  }

  public void setServiceStatus(Long serviceStatus) {
    this.serviceStatus = serviceStatus;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Long getServiceId() {
    return serviceId;
  }

  public void setServiceId(Long serviceId) {
    this.serviceId = serviceId;
  }

  // Equals and hashCode methods
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    ServiceBooking booking = (ServiceBooking) o;
    return Objects.equals(id, booking.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  // toString method
  @Override
  public String toString() {
    return "Booking{" +
        "id=" + id +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", employeeId=" + employeeId +
        ", serviceStatus=" + serviceStatus +
        ", customerId=" + customerId +
        ", serviceId=" + serviceId +
        '}';
  }

}
