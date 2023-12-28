package com.vu.localhost.poss.employee.model;

import java.util.Objects;

import javax.validation.constraints.*;

import com.vu.localhost.poss.role.model.Role;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotNull
  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id")
  private Role role;

  @Column(name = "tenant_id", nullable = false)
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
    return id;
  }

  public void setEmployeeId(Long id) {
    this.id = id;
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
    return "Employee{" +
        "employeeId=" + id +
        ", name='" + name + '\'' +
        ", roleId=" + (role != null ? role : null) +
        ", tenantId=" + tenantId +
        '}';
  }
}
