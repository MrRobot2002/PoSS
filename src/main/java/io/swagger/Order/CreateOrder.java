package io.swagger.Order;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

@Validated
public class CreateOrder {

  @JsonProperty("orderId")
  private Long orderId = null;

  @JsonProperty("customer_id")
  private Integer customerId = null;

  @JsonProperty("employee_id")
  private Long employeeId = null;

  @JsonProperty("discount_id")
  private Long discountId = null;

  @JsonProperty("tips")
  private Float tips = null;

  @JsonProperty("tenant")
  private Long tenant = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    DONE("DONE"),

    IN_PROCESS("IN_PROCESS"),

    FREEZED("FREEZED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
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

  public void setTips(Float tips) {
    this.tips = tips;
  }

  public Float getTips() {
    return tips;
  }

  public void setTenant(Long tenant) {
    this.tenant = tenant;
  }

  public Long getTenant() {
    return tenant;
  }

  @Schema(required = true, description = "")
  @NotNull
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
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
    CreateOrder order = (CreateOrder) o;
    return Objects.equals(this.orderId, order.orderId) &&
        Objects.equals(this.customerId, order.customerId) &&
        Objects.equals(this.employeeId, order.employeeId) &&
        Objects.equals(this.discountId, order.discountId) &&
        Objects.equals(this.tips, order.tips) &&
        Objects.equals(this.tenant, order.tenant) &&
        Objects.equals(this.status, order.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, customerId, employeeId, discountId, tips, tenant, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");

    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    discountId: ").append(toIndentedString(discountId)).append("\n");
    sb.append("    tips: ").append(toIndentedString(tips)).append("\n");
    sb.append("    items: ").append(toIndentedString(tenant)).append("\n");
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
