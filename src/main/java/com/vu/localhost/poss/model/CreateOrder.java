package com.vu.localhost.poss.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import com.vu.localhost.poss.item.Item;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")

public class CreateOrder {
  @JsonProperty("customer_id")
  private Integer customerId = null;

  @JsonProperty("employee_id")
  private Long employeeId = null;

  @JsonProperty("discount_id")
  private Long discountId = null;

  @JsonProperty("tips")
  private Float tips = null;

  @JsonProperty("items")
  @Valid
  private List<Item> items = null;

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

  public CreateOrder customerId(Integer customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * 
   * @return customerId
   **/
  @Schema(description = "")

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public CreateOrder employeeId(Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  /**
   * Get employeeId
   * 
   * @return employeeId
   **/
  @Schema(required = true, description = "")
  @NotNull

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public CreateOrder discountId(Long discountId) {
    this.discountId = discountId;
    return this;
  }

  /**
   * Get discountId
   * 
   * @return discountId
   **/
  @Schema(description = "")

  public Long getDiscountId() {
    return discountId;
  }

  public void setDiscountId(Long discountId) {
    this.discountId = discountId;
  }

  public CreateOrder tips(Float tips) {
    this.tips = tips;
    return this;
  }

  /**
   * Get tips
   * 
   * @return tips
   **/
  @Schema(description = "")

  public Float getTips() {
    return tips;
  }

  public void setTips(Float tips) {
    this.tips = tips;
  }

  public CreateOrder items(List<Item> items) {
    this.items = items;
    return this;
  }

  public CreateOrder addItemsItem(Item itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<Item>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * 
   * @return items
   **/
  @Schema(description = "")
  @Valid
  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public CreateOrder status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * 
   * @return status
   **/
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
    CreateOrder createOrder = (CreateOrder) o;
    return Objects.equals(this.customerId, createOrder.customerId) &&
        Objects.equals(this.employeeId, createOrder.employeeId) &&
        Objects.equals(this.discountId, createOrder.discountId) &&
        Objects.equals(this.tips, createOrder.tips) &&
        Objects.equals(this.items, createOrder.items) &&
        Objects.equals(this.status, createOrder.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, employeeId, discountId, tips, items, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateOrder {\n");

    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    discountId: ").append(toIndentedString(discountId)).append("\n");
    sb.append("    tips: ").append(toIndentedString(tips)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
