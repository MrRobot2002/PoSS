package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.Price;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PaymentDetail
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-24T22:29:17.594034+02:00[Europe/Vilnius]")


public class PaymentDetail   {
  @JsonProperty("orderId")
  private Long orderId = null;

  @JsonProperty("paymentId")
  private String paymentId = null;

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

  @JsonProperty("date")
  private OffsetDateTime date = null;

  public PaymentDetail orderId(Long orderId) {
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

  public PaymentDetail paymentId(String paymentId) {
    this.paymentId = paymentId;
    return this;
  }

  /**
   * Get paymentId
   * @return paymentId
   **/
  @Schema(description = "")
  
    public String getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

  public PaymentDetail paymentType(PaymentTypeEnum paymentType) {
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

  public PaymentDetail paymentState(PaymentStateEnum paymentState) {
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

  public PaymentDetail price(Price price) {
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

  public PaymentDetail date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentDetail paymentDetail = (PaymentDetail) o;
    return Objects.equals(this.orderId, paymentDetail.orderId) &&
        Objects.equals(this.paymentId, paymentDetail.paymentId) &&
        Objects.equals(this.paymentType, paymentDetail.paymentType) &&
        Objects.equals(this.paymentState, paymentDetail.paymentState) &&
        Objects.equals(this.price, paymentDetail.price) &&
        Objects.equals(this.date, paymentDetail.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, paymentId, paymentType, paymentState, price, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentDetail {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
    sb.append("    paymentType: ").append(toIndentedString(paymentType)).append("\n");
    sb.append("    paymentState: ").append(toIndentedString(paymentState)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
