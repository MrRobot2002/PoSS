package io.swagger.Employee;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateEmployee {

  @JsonProperty("name")
  private String name = null;
  @JsonProperty("role")
  private Long role = null;
  @JsonProperty("tenant")
  private Long tenant = null;
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

  public CreateEmployee tenant(Long tenant) {
    this.tenant = tenant;
    return this;
  }

  public Long getTenant() {
    return tenant;
  }

  public void setTenant(Long tenant) {
    this.tenant = tenant;
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
        Objects.equals(this.tenant, employee.tenant) &&
        Objects.equals(this.shortCode, employee.shortCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, role, tenant, shortCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
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
