package io.swagger.Service;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.Employee.CreateEmployee;
import io.swagger.Price.Price;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateService
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")

public class CreateService {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("duration")
  private Integer duration = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("price")
  private Price price = null;

  @JsonProperty("tenant")
  private Long tenant = null;

  public CreateService name(String name) {
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

  public CreateService description(String description) {
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

  public CreateService duration(Integer duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get description
   * 
   * @return description
   **/
  @Schema(required = true, description = "")
  @NotNull

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public CreateService price(Price price) {
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

  public CreateService tenant(Long tenant) {
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
    CreateService createService = (CreateService) o;
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
