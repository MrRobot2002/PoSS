package com.vu.localhost.poss.discount.model;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.*;
import javax.persistence.*;

@Entity
@Table(name = "Discount")
public class Discount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long discountId = null;

  @NotNull
  @Column(name = "code")
  private String code = null;

  @NotNull
  @Column(name = "discount", precision = 10, scale = 2)
  private Double discount = null;

  @NotNull
  @Column(name = "tenant_id")
  private Long tenantId;

  public Discount discountId(Long discountId) {
    this.discountId = discountId;
    return this;
  }

  public Long getDiscountId() {
    return discountId;
  }

  public void setDiscountId(Long discountId) {
    this.discountId = discountId;
  }

  public Discount code(String code) {
    this.code = code;
    return this;
  }

  @Schema(description = "")

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Discount discount(Double discount) {
    this.discount = discount;
    return this;
  }

  @Schema(required = true, description = "")
  @NotNull

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  public Long getTenantId() {
    return tenantId;
  }

  public void setTenantId(Long tenantId) {
    this.tenantId = tenantId;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Discount discount = (Discount) o;
    return Objects.equals(this.discountId, discount.discountId) &&
        Objects.equals(this.code, discount.code) &&
        Objects.equals(this.discount, discount.discount) &&
        Objects.equals(this.tenantId, discount.tenantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(discountId, code, discount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class discount {\n");

    sb.append("    discountId: ").append(toIndentedString(discountId)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
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
