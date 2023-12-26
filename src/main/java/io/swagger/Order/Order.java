
package io.swagger.Order;

import javax.persistence.*;
import javax.validation.constraints.*;

import io.swagger.Loyalty.Loyalty;
import io.swagger.Tenant.Tenant;

import java.util.Objects;

@Entity
@Table(name = "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long orderId;

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

    // Assuming loyalty_id is a foreign key to a Loyalty entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loyalty_id")
    private Loyalty loyalty; // Make sure you have a Loyalty entity defined similarly.

    // Assuming tenant_id is a foreign key to a Tenant entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant; // Make sure you have a Tenant entity defined similarly.

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Order))
            return false;
        Order that = (Order) o;
        return Objects.equals(getOrderId(), that.getOrderId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", loyaltyId=" + (loyalty != null ? loyalty : null) +
                ", tenantId=" + (tenant != null ? tenant : null) +
                '}';
    }

}
