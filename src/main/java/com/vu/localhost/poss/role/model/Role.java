package com.vu.localhost.poss.role.model;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "permission", nullable = false)
    private Long permission;

    public Long getRoleId() {
        return id;
    }

    public void setRoleId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPermission() {
        return permission;
    }

    public void setPermission(Long permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permission=" + permission +
                '}';
    }
}