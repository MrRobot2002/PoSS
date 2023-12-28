package com.vu.localhost.poss.employee.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateEmployee {

  @JsonProperty("name")
  private String name = null;
  @JsonProperty("role")
  private Long role = null;
  @JsonProperty("tenant")
  private Long tenantId = null;
  @JsonProperty("short_code")
  private String shortCode = null;

  public CreateEmployee name(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateEmployee role(Long role) {
    this.role = role;
    return this;
  }

  public Long getRole() {
    return role;
  }

  public void setRole(Long role) {
    this.role = role;
  }

  public CreateEmployee tenant(Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  public Long getTenantId() {
    return tenantId;
  }

  public void setTenantId(Long tenantId) {
    this.tenantId = tenantId;
  }

  public String getShortCode() {
    return shortCode;
  }

  public void setShortCode(String shortCode) {
    this.shortCode = shortCode;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateEmployee employee = (CreateEmployee) o;
    return Objects.equals(this.name, employee.name) &&
        Objects.equals(this.role, employee.role) &&
        Objects.equals(this.tenantId, employee.tenantId) &&
        Objects.equals(this.shortCode, employee.shortCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, role, tenantId, shortCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    tenant: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    shortCode: ").append(toIndentedString(shortCode)).append("\n");
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
