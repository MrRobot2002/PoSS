package com.vu.localhost.poss.service.model;
import javax.persistence.*;
import com.vu.localhost.poss.common.Price;

import java.util.Objects;

@Entity
@Table(name = "Service")
public class Service {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "duration")
  private Long duration;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "amount", column = @Column(name = "amount")),
      @AttributeOverride(name = "currency", column = @Column(name = "currency"))
  })
  private Price price;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "tenant_id", nullable = false)
  private Long tenantId;

  // Getters and Setters
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

  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getTenant() {
    return tenantId;
  }

  public void setTenant(Long tenantId) {
    this.tenantId = tenantId;
  }

  // Equals and hashCode methods
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Service service = (Service) o;
    return Objects.equals(id, service.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  // toString method
  @Override
  public String toString() {
    return "service{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", duration=" + duration +
        ", price=" + price +
        ", description='" + description + '\'' +
        ", tenantId=" + tenantId +
        '}';
  }
}
