package io.swagger.Product;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.Price.Price;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Product
 */

@Entity
@Table(name = "Product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long productId = null;

  @NotNull
  @Column(name = "name", nullable = false)
  private String name = null;

  private Price price = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  public Product productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * 
   * @return productId
   **/
  @Schema(description = "")

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Product name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * 
   * @return name
   **/
  @Schema(description = "")

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Product price(Price price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * 
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

  public Product quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * 
   * @return quantity
   **/
  @Schema(description = "")

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.productId, product.productId) &&
        Objects.equals(this.name, product.name) &&
        Objects.equals(this.price, product.price) &&
        Objects.equals(this.quantity, product.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, name, price, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");

    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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
