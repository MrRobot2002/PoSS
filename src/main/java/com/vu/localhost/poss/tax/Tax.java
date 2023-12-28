package com.vu.localhost.poss.tax;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tax")
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "percent", nullable = false)
    private BigDecimal percent;

    @NotEmpty
    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;

    public Long getTaxId() {
        return id;
    }

    public void setTaxId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long id) {
        this.tenantId = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Tax tax = (Tax) o;
        return Objects.equals(id, tax.id);
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
                ", percent='" + percent + '\'' +
                ", tenantId='" + tenantId + '\'' +
                '}';
    }

}