package com.vu.localhost.poss.employee.model;

import java.util.Objects;

import com.vu.localhost.poss.role.Role;
import javax.validation.constraints.*;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long emloyeeId;

  @NotNull
  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id")
  private Role role;

  @NotNull
  @Column(name = "tenant_id")
  private Long tenantId;

  @Column(name = "short_code")
  private String shortCode;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getEmployeeId() {
    return emloyeeId;
  }

  public void setEmployeeId(Long id) {
    this.emloyeeId = id;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
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
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Employee))
      return false;
    Employee that = (Employee) o;
    return Objects.equals(getEmployeeId(), that.getEmployeeId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getEmployeeId());
  }

  @Override
  public String toString() {
    return "employee{" +
        "employeeId=" + emloyeeId +
        ", name='" + name + '\'' +
        ", roleId=" + (role != null ? role : null) +
        ", tenantId=" + (tenantId != null ? tenantId : null) +
        '}';
  }
}
