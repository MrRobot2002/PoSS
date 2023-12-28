package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.common.Price;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ServiceDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")

public class ServiceDetails {
  @JsonProperty("serviceId")
  private Long serviceId = null;

  @JsonProperty("duration")
  private Long duration = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("price")
  private Price price = null;

  @JsonProperty("availability")
  private Boolean availability = null;

  public ServiceDetails serviceId(Long serviceId) {
    this.serviceId = serviceId;
    return this;
  }

  /**
   * Get serviceId
   * 
   * @return serviceId
   **/
  @Schema(description = "")

  public Long getServiceId() {
    return serviceId;
  }

  public void setServiceId(Long serviceId) {
    this.serviceId = serviceId;
  }

  public ServiceDetails duration(Long duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get duration
   * 
   * @return duration
   **/
  @Schema(description = "")

  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }

  public ServiceDetails name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * 
   * @return name
   **/
  @Schema(required = true, description = "")
  @NotNull

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceDetails description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * 
   * @return description
   **/
  @Schema(required = true, description = "")
  @NotNull

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceDetails price(Price price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * 
   * @return price
   **/
  @Schema(required = true, description = "")
  @NotNull

  @Valid
  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public ServiceDetails availability(Boolean availability) {
    this.availability = availability;
    return this;
  }

  /**
   * Get availability
   * 
   * @return availability
   **/
  @Schema(required = true, description = "")
  @NotNull

  public Boolean isAvailability() {
    return availability;
  }

  public void setAvailability(Boolean availability) {
    this.availability = availability;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceDetails serviceDetails = (ServiceDetails) o;
    return Objects.equals(this.serviceId, serviceDetails.serviceId) &&
        Objects.equals(this.duration, serviceDetails.duration) &&
        Objects.equals(this.name, serviceDetails.name) &&
        Objects.equals(this.description, serviceDetails.description) &&
        Objects.equals(this.price, serviceDetails.price) &&
        Objects.equals(this.availability, serviceDetails.availability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceId, duration, name, description, price, availability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceDetails {\n");

    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
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
