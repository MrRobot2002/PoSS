package com.vu.localhost.poss.payment.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vu.localhost.poss.common.PaymentStateEnum;
import com.vu.localhost.poss.common.PaymentTypeEnum;
import com.vu.localhost.poss.common.Price;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

@Validated
public class PaymentRequestDTO {
  @JsonProperty("orderId")
  private Long orderId = null;

  @JsonProperty("paymentType")
  private PaymentTypeEnum paymentType = null;

  @JsonProperty("paymentState")
  private PaymentStateEnum paymentState = null;

  @JsonProperty("price")
  private Price price = null;

  @JsonProperty("tenant")
  private Long tenant = null;

  public PaymentRequestDTO orderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public PaymentRequestDTO paymentType(PaymentTypeEnum paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  public PaymentTypeEnum getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentTypeEnum paymentType) {
    this.paymentType = paymentType;
  }

  public PaymentRequestDTO paymentState(PaymentStateEnum paymentState) {
    this.paymentState = paymentState;
    return this;
  }

  public PaymentStateEnum getPaymentState() {
    return paymentState;
  }

  public void setPaymentState(PaymentStateEnum paymentState) {
    this.paymentState = paymentState;
  }

  public PaymentRequestDTO price(Price price) {
    this.price = price;
    return this;
  }

  @Valid
  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public PaymentRequestDTO tenant(Long tenant) {
    this.tenant = tenant;
    return this;
  }

  public Long getTenant() {
    return tenant;
  }

  public void setTenant(Long tenant) {
    this.tenant = tenant;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentRequestDTO paymentRequest = (PaymentRequestDTO) o;
    return Objects.equals(this.orderId, paymentRequest.orderId) &&
        Objects.equals(this.paymentType, paymentRequest.paymentType) &&
        Objects.equals(this.paymentState, paymentRequest.paymentState) &&
        Objects.equals(this.price, paymentRequest.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, paymentType, paymentState, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRequest {\n");

    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    paymentType: ").append(toIndentedString(paymentType)).append("\n");
    sb.append("    paymentState: ").append(toIndentedString(paymentState)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
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
