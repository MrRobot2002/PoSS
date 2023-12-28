package com.vu.localhost.poss.service.model;

import javax.persistence.*;

import com.vu.localhost.poss.customer.model.Customer;
import com.vu.localhost.poss.employee.model.Employee;

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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id", nullable = false)
  private Employee employee; // Assuming the employee entity is defined

  @Column(name = "service_status", nullable = false)
  private Integer serviceStatus;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private Customer customer; // Assuming the customer entity is defined and can be null

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "service_id", nullable = false)
  private Service service; // Assuming the service entity is defined

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

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Integer getServiceStatus() {
    return serviceStatus;
  }

  public void setServiceStatus(Integer serviceStatus) {
    this.serviceStatus = serviceStatus;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
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
        ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
        ", serviceStatus=" + serviceStatus +
        ", customerId=" + (customer != null ? customer.getCustomerId() : null) +
        ", serviceId=" + (service != null ? service.getId() : null) +
        '}';
  }
}
