package com.vu.localhost.poss.service.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.vu.localhost.poss.common.Price;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * CreateService
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")

public class ServiceRequestDTO {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("duration")
  private Long duration = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("price")
  private Price price = null;

  @JsonProperty("tenant")
  private Long tenant = null;

  public ServiceRequestDTO name(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceRequestDTO description(String description) {
    this.description = description;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceRequestDTO duration(Long duration) {
    this.duration = duration;
    return this;
  }

  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }

  public ServiceRequestDTO price(Price price) {
    this.price = price;
    return this;
  }

  @Valid
  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public ServiceRequestDTO tenant(Long tenant) {
    this.tenant = tenant;
    return this;
  }

  public Long getTenant() {
    return tenant;
  }

  public void setTenant(Long tenant) {
    this.tenant = tenant;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceRequestDTO createService = (ServiceRequestDTO) o;
    return Objects.equals(this.name, createService.name) &&
        Objects.equals(this.description, createService.description) &&
        Objects.equals(this.price, createService.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateService {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
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
