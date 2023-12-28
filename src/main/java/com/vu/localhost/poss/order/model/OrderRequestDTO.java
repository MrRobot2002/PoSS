package com.vu.localhost.poss.order.model;

import java.math.BigDecimal;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.vu.localhost.poss.common.OrderStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

@Validated
public class OrderRequestDTO {

    @JsonProperty("orderId")
    private Long orderId = null;

    @JsonProperty("customer_id")
    private Long customerId = null;

    @JsonProperty("employee_id")
    private Long employeeId = null;

    @JsonProperty("discount_id")
    private Long discountId = null;

    @JsonProperty("tax_id")
    private Long taxId = null;

    @JsonProperty("tips")
    private BigDecimal tips = null;

    @JsonProperty("tenant_id")
    private Long tenantId = null;

    @JsonProperty("status")
    private OrderStatusEnum status = null;

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

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTips(BigDecimal tips) {
        this.tips = tips;
    }

    public BigDecimal getTips() {
        return tips;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    @Schema(required = true, description = "")
    @NotNull
    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderRequestDTO order = (OrderRequestDTO) o;
        return Objects.equals(this.orderId, order.orderId) &&
                Objects.equals(this.customerId, order.customerId) &&
                Objects.equals(this.employeeId, order.employeeId) &&
                Objects.equals(this.discountId, order.discountId) &&
                Objects.equals(this.tips, order.tips) &&
                Objects.equals(this.tenantId, order.tenantId) &&
                Objects.equals(this.status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, employeeId, discountId, tips, tenantId, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class order {\n");

        sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
        sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
        sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
        sb.append("    discountId: ").append(toIndentedString(discountId)).append("\n");
        sb.append("    tips: ").append(toIndentedString(tips)).append("\n");
        sb.append("    items: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}