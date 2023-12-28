package com.vu.localhost.poss.employee.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

// EmployeeServiceId class
@Embeddable
public class EmployeeServiceId implements Serializable {

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "service_id")
    private Long serviceId;

    // Getters and setters, equals, hashCode, and toString methods
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeServiceId that = (EmployeeServiceId) o;
        return employeeId.equals(that.employeeId) && serviceId.equals(that.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, serviceId);
    }

    @Override
    public String toString() {
        return "EmployeeServiceId{" +
                "employeeId=" + employeeId +
                ", serviceId=" + serviceId +
                '}';
    }
}