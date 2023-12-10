package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Employee
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-10T17:52:19.390156+02:00[Europe/Vilnius]")

@Entity
@Table(name = "employees")
public class Employee {

  @Id
  @JsonProperty("employeeId")
  private Long employeeId = null;

  @Column(name = "name")
  @JsonProperty("name")
  private String name = null;

  @ManyToOne
  @JoinColumn(name = "role_id", referencedColumnName = "role_id")
  @JsonProperty("role_id")
  private Role role;

  public Employee employeeId(Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  /**
   * Get employeeId
   * 
   * @return employeeId
   **/
  @Schema(description = "")

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public Employee name(String name) {
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

  public Employee role(Role role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * 
   * @return role
   **/
  @Schema(required = true, description = "")
  @NotNull

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.employeeId, employee.employeeId) &&
        Objects.equals(this.name, employee.name) &&
        Objects.equals(this.role, employee.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeId, name, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");

    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
