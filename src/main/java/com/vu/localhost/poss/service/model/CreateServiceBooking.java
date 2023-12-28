package com.vu.localhost.poss.service.model;

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
 * CreateServiceBooking
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")

public class CreateServiceBooking {
  @JsonProperty("customerId")
  private Long customerId = null;

  @JsonProperty("employeeId")
  private Long employeeId = null;

  @JsonProperty("bookingTimeStart")
  private OffsetDateTime bookingTimeStart = null;

  @JsonProperty("bookingTimeEnd")
  private OffsetDateTime bookingTimeEnd = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    FREE("FREE"),

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

    public static Long getEnumId(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return Long.valueOf(b.ordinal());
        }
      }
      return null;
    }

    public static StatusEnum getEnumById(Long id) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.ordinal() == id) {
          return b;
        }
      }
      return null;
    }

    public Long getOrdinal() {
      return Long.valueOf(this.ordinal());
    }

  }

  @JsonProperty("status")
  private StatusEnum status = null;

  public CreateServiceBooking customerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * 
   * @return customerId
   **/
  @Schema(description = "")

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public CreateServiceBooking employeeId(Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  /**
   * Get employeeId
   * 
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

  public CreateServiceBooking bookingTimeStart(OffsetDateTime bookingTimeStart) {
    this.bookingTimeStart = bookingTimeStart;
    return this;
  }

  /**
   * Get bookingTimeStart
   * 
   * @return bookingTimeStart
   **/
  @Schema(description = "")

  @Valid
  public OffsetDateTime getBookingTimeStart() {
    return bookingTimeStart;
  }

  public void setBookingTimeStart(OffsetDateTime bookingTimeStart) {
    this.bookingTimeStart = bookingTimeStart;
  }

  public CreateServiceBooking bookingTimeEnd(OffsetDateTime bookingTimeEnd) {
    this.bookingTimeEnd = bookingTimeEnd;
    return this;
  }

  /**
   * Get bookingTimeEnd
   * 
   * @return bookingTimeEnd
   **/
  @Schema(description = "")

  @Valid
  public OffsetDateTime getBookingTimeEnd() {
    return bookingTimeEnd;
  }

  public void setBookingTimeEnd(OffsetDateTime bookingTimeEnd) {
    this.bookingTimeEnd = bookingTimeEnd;
  }

  public CreateServiceBooking status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * 
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
    CreateServiceBooking createServiceBooking = (CreateServiceBooking) o;
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
