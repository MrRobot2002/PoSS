package com.vu.localhost.poss.service.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vu.localhost.poss.common.ServiceBookingStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Validated
public class ServiceBookingRequestDTO {
  @JsonProperty("customerId")
  private Long customerId = null;

  @JsonProperty("employeeId")
  private Long employeeId = null;

  @JsonProperty("bookingTimeStart")
  private LocalDateTime bookingTimeStart = null;

  @JsonProperty("bookingTimeEnd")
  private LocalDateTime bookingTimeEnd = null;

  @JsonProperty("status")
  private ServiceBookingStatusEnum status = null;

  public ServiceBookingRequestDTO customerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  @Schema(description = "")

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public ServiceBookingRequestDTO employeeId(Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  @Schema(required = true, description = "")
  @NotNull

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public ServiceBookingRequestDTO bookingTimeStart(LocalDateTime bookingTimeStart) {
    this.bookingTimeStart = bookingTimeStart;
    return this;
  }

  @Schema(description = "")

  @Valid
  public LocalDateTime getBookingTimeStart() {
    return bookingTimeStart;
  }

  public void setBookingTimeStart(LocalDateTime bookingTimeStart) {
    this.bookingTimeStart = bookingTimeStart;
  }

  public ServiceBookingRequestDTO bookingTimeEnd(LocalDateTime bookingTimeEnd) {
    this.bookingTimeEnd = bookingTimeEnd;
    return this;
  }

  @Schema(description = "")

  @Valid
  public LocalDateTime getBookingTimeEnd() {
    return bookingTimeEnd;
  }

  public void setBookingTimeEnd(LocalDateTime bookingTimeEnd) {
    this.bookingTimeEnd = bookingTimeEnd;
  }

  public ServiceBookingRequestDTO status(ServiceBookingStatusEnum status) {
    this.status = status;
    return this;
  }

  public ServiceBookingStatusEnum getStatus() {
    return status;
  }

  public void setStatus(ServiceBookingStatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceBookingRequestDTO createServiceBooking = (ServiceBookingRequestDTO) o;
    return Objects.equals(this.customerId, createServiceBooking.customerId) &&
        Objects.equals(this.employeeId, createServiceBooking.employeeId) &&
        Objects.equals(this.bookingTimeStart, createServiceBooking.bookingTimeStart) &&
        Objects.equals(this.bookingTimeEnd, createServiceBooking.bookingTimeEnd) &&
        Objects.equals(this.status, createServiceBooking.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, employeeId, bookingTimeStart, bookingTimeEnd, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateServiceBooking {\n");

    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    bookingTimeStart: ").append(toIndentedString(bookingTimeStart)).append("\n");
    sb.append("    bookingTimeEnd: ").append(toIndentedString(bookingTimeEnd)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
