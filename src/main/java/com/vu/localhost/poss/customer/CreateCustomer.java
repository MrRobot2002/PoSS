package com.vu.localhost.poss.customer;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * CreateCustomer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")

public class CreateCustomer {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("loyalty")
  private Optional<Long> loyalty;

  @JsonProperty("tenantId")
  private Long tenantId = null;

  public CreateCustomer name(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateCustomer email(String email) {
    this.email = email;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreateCustomer tenantId(Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  @Schema(description = "")
  public Long getTenantId() {
    return tenantId;
  }

  public void setTenantId(Long tenantId) {
    this.tenantId = tenantId;
  }

  public CreateCustomer phone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public CreateCustomer loyalty(Optional<Long> loyalty) {
    this.loyalty = loyalty;
    return this;
  }

  public Optional<Long> getLoyalty() {
    return loyalty;
  }

  public void setLoyalty(Optional<Long> loyalty) {
    this.loyalty = loyalty;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCustomer createCustomer = (CreateCustomer) o;
    return Objects.equals(this.name, createCustomer.name) &&
        Objects.equals(this.email, createCustomer.email) &&
        Objects.equals(this.phone, createCustomer.phone) &&
        Objects.equals(this.loyalty, createCustomer.loyalty) &&
        Objects.equals(this.tenantId, createCustomer.tenantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, phone, loyalty, tenantId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCustomer {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    loyalty: ").append(toIndentedString(loyalty)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
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