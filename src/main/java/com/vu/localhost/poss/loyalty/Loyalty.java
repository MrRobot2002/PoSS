package com.vu.localhost.poss.loyalty;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.vu.localhost.poss.tenant.Tenant;

@Entity
@Table(name = "Loyalty")
public class Loyalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "discount", nullable = false)
    private Double discount;

    // Assuming there's a Many-To-One relationship with tenant
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getDiscount() {
            return discount;
        }

        public void setDiscount(Double discount) {
            this.discount = discount;
        }

        public Tenant getTenant() {
            return tenant;
        }

        public void setTenant(Tenant tenant) {
            this.tenant = tenant;
        }
        
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loyalty loyalty = (Loyalty) o;
        return Objects.equals(id, loyalty.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
public String toString() {
    return "loyalty{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", discount=" + discount +
            '}';
}

}