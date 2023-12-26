package io.swagger.Employee;

import java.util.Objects;
import java.util.Date;

import javax.validation.constraints.*;
import javax.persistence.*;

@Entity
@Table(name = "Employee_Availability")
public class EmployeeAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Long employeeId;

    @NotNull(message = "Start time cannot be null")
    @Column(name = "start_time")
    private Date startTime;

    @NotNull(message = "End time cannot be null")
    @Column(name = "end_time")
    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long id) {
        this.employeeId = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date time) {
        this.startTime = time;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date time) {
        this.endTime = time;
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
        return "EmployeeAvailability{" +
                "id=" + id +
                ", employeeId='" + employeeId + '\'' +
                ", startTime=" + startTime + '\'' +
                ", endTime=" + endTime + '\'' +
                '}';
    }
}
