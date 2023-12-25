package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.Price;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PaymentRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")


public class PaymentRequest   {
  @JsonProperty("orderId")
  private Long orderId = null;

  /**
   * Gets or Sets paymentType
   */
  public enum PaymentTypeEnum {
    CARD("CARD"),
    
    CASH("CASH");

    private String value;

    PaymentTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PaymentTypeEnum fromValue(String text) {
      for (PaymentTypeEnum b : PaymentTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("paymentType")
  private PaymentTypeEnum paymentType = null;

  /**
   * Gets or Sets paymentState
   */
  public enum PaymentStateEnum {
    UNPAID("UNPAID"),
    
    PENDING("PENDING"),
    
    PARTIALLY_PAID("PARTIALLY_PAID"),
    
    PAID("PAID");

    private String value;

    PaymentStateEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PaymentStateEnum fromValue(String text) {
      for (PaymentStateEnum b : PaymentStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("paymentState")
  private PaymentStateEnum paymentState = null;

  @JsonProperty("price")
  private Price price = null;

  public PaymentRequest orderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
   **/
  @Schema(description = "")
  
    public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public PaymentRequest paymentType(PaymentTypeEnum paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * Get paymentType
   * @return paymentType
   **/
  @Schema(description = "")
  
    public PaymentTypeEnum getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentTypeEnum paymentType) {
    this.paymentType = paymentType;
  }

  public PaymentRequest paymentState(PaymentStateEnum paymentState) {
    this.paymentState = paymentState;
    return this;
  }

  /**
   * Get paymentState
   * @return paymentState
   **/
  @Schema(description = "")
  
    public PaymentStateEnum getPaymentState() {
    return paymentState;
  }

  public void setPaymentState(PaymentStateEnum paymentState) {
    this.paymentState = paymentState;
  }

  public PaymentRequest price(Price price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
  @Schema(description = "")
  
    @Valid
    public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentRequest paymentRequest = (PaymentRequest) o;
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
