
package com.vu.localhost.poss.customer.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.vu.localhost.poss.loyalty.Loyalty;

import java.util.Objects;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long customerId;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Email
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "phone", nullable = false)
    private String phone;

    // Assuming loyalty_id is a foreign key to a loyalty entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loyalty_id")
    private Loyalty loyalty; // Make sure you have a loyalty entity defined similarly.

    @NotNull
    @Column(name = "tenant_id")
    private Long tenantId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Loyalty getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(Loyalty loyalty) {
        this.loyalty = loyalty;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Customer))
            return false;
        Customer that = (Customer) o;
        return Objects.equals(getCustomerId(), that.getCustomerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId());
    }

    @Override
    public String toString() {
        return "customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", loyaltyId=" + (loyalty != null ? loyalty : null) +
                ", tenantId=" + (tenantId != null ? tenantId : null) +
                '}';
    }

}
