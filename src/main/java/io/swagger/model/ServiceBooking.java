package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ServiceBooking
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-10T17:29:46.806586+02:00[Europe/Vilnius]")


public class ServiceBooking   {
  @JsonProperty("bookingId")
  private Long bookingId = null;

  @JsonProperty("serviceId")
  private Long serviceId = null;

  @JsonProperty("customerId")
  private Long customerId = null;

  @JsonProperty("employeeId")
  private Long employeeId = null;

  @JsonProperty("bookingTime")
  private OffsetDateTime bookingTime = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    SCHEDULED("SCHEDULED"),
    
    COMPLETED("COMPLETED"),
    
    CANCELLED("CANCELLED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  public ServiceBooking bookingId(Long bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  /**
   * Get bookingId
   * @return bookingId
   **/
  @Schema(description = "")
  
    public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public ServiceBooking serviceId(Long serviceId) {
    this.serviceId = serviceId;
    return this;
  }

  /**
   * Get serviceId
   * @return serviceId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Long getServiceId() {
    return serviceId;
  }

  public void setServiceId(Long serviceId) {
    this.serviceId = serviceId;
  }

  public ServiceBooking customerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public ServiceBooking employeeId(Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  /**
   * Get employeeId
   * @return employeeId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public ServiceBooking bookingTime(OffsetDateTime bookingTime) {
    this.bookingTime = bookingTime;
    return this;
  }

  /**
   * Get bookingTime
   * @return bookingTime
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public OffsetDateTime getBookingTime() {
    return bookingTime;
  }

  public void setBookingTime(OffsetDateTime bookingTime) {
    this.bookingTime = bookingTime;
  }

  public ServiceBooking status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(description = "")
  
    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
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
    ServiceBooking serviceBooking = (ServiceBooking) o;
    return Objects.equals(this.bookingId, serviceBooking.bookingId) &&
        Objects.equals(this.serviceId, serviceBooking.serviceId) &&
        Objects.equals(this.customerId, serviceBooking.customerId) &&
        Objects.equals(this.employeeId, serviceBooking.employeeId) &&
        Objects.equals(this.bookingTime, serviceBooking.bookingTime) &&
        Objects.equals(this.status, serviceBooking.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId, serviceId, customerId, employeeId, bookingTime, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceBooking {\n");
    
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    bookingTime: ").append(toIndentedString(bookingTime)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
