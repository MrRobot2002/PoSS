package com.vu.localhost.poss.employee.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Employee_Services")
public class EmployeeServices implements Serializable {

    @EmbeddedId
    public EmployeeServiceId id;


    public EmployeeServiceId getId() {
        return id;
    }

    public void setId(EmployeeServiceId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmployeeService{" +
                "id=" + id +
                '}';
    }



}
