package io.swagger.Payment;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import javax.validation.constraints.NotNull;

import io.swagger.Order.Order;
import io.swagger.common.PaymentStateEnum;
import io.swagger.common.PaymentTypeEnum;
import io.swagger.common.Price;

@Entity
@Table(name = "Payment")
public class Payment {

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", nullable = false)
  private Order orderId;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "amount", column = @Column(name = "amount")),
      @AttributeOverride(name = "currency", column = @Column(name = "currency"))
  })
  private Price price;

  @NotNull
  @Column(name = "state", nullable = false)
  private PaymentStateEnum state;

  @NotNull
  @Column(name = "type", nullable = false)
  private PaymentTypeEnum type;

  @NotNull
  @Column(name = "date", nullable = false)
  private Timestamp date;

  @NotNull
  @Column(name = "tenant_id", nullable = false)
  private Long tenant;

  public Order getOrderId() {
    return orderId;
  }

  public void setOrderId(Order orderId) {
    this.orderId = orderId;
  }

  public String getPaymentId() {
    return id;
  }

  public void setPaymentId(String id) {
    this.id = id;
  }

  public PaymentTypeEnum getPaymentType() {
    return type;
  }

  public void setPaymentType(PaymentTypeEnum paymentType) {
    this.type = paymentType;
  }

  public PaymentStateEnum getPaymentState() {
    return state;
  }

  public void setPaymentState(PaymentStateEnum state) {
    this.state = state;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setCurrentDate() {
    long currentTimeMillis = System.currentTimeMillis();
    Timestamp currentTimestamp = new Timestamp(currentTimeMillis);
    this.date = currentTimestamp;
  }

  public Long getTenant() {
    return tenant;
  }

  public void setTenant(Long tenant) {
    this.tenant = tenant;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Payment payment = (Payment) o;
    return Objects.equals(id, payment.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Payment{" +
        "id='" + id + '\'' +
        ", orderId=" + orderId +
        ", price=" + price +
        ", state=" + state +
        ", type=" + type +
        ", date=" + date +
        ", tenant=" + tenant +
        '}';
  }

}