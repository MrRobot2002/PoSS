
package com.vu.localhost.poss.order.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import com.vu.localhost.poss.common.StatusEnum;
import com.vu.localhost.poss.orderItem.OrderItem;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "`Order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long orderId;

    @Column(name = "customer_id")
    private Long customerId;

    @NotNull
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "discount_id")
    private Long discountId;

    @Column(name = "tax_id")
    private Long taxId;

    @Column(name = "tips")
    private BigDecimal tips;

    @NotNull
    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;

    @NotNull
    @Column(name = "status", nullable = false)
    private StatusEnum status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    public Order status(StatusEnum status) {
        this.status = status;
        return this;
    }

    @Schema(description = "")
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employee_id) {
        this.employeeId = employee_id;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discount_id) {
        this.discountId = discount_id;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long tax_id) {
        this.taxId = tax_id;
    }

    public BigDecimal getTips() {
        return tips;
    }

    public void setTips(BigDecimal tips) {
        this.tips = tips;
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
                ", customerId=" + customerId +
                ", employeeId=" + employeeId +
                ", status=" + status +
                ", discountId=" + discountId +
                ", tips=" + tips +
                ", tenantId=" + (tenantId != null ? tenantId : null) +
                '}';
    }

    public void addItem(OrderItem item) {
        item.setOrder(this);
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
