package io.swagger.Item;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.Price.Price;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Item
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")

public class Item {
  /**
   * Gets or Sets category
   */
  public enum CategoryEnum {
    PRODUCT("PRODUCT"),

    SERVICE("SERVICE");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String text) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("category")
  private CategoryEnum category = null;

  @JsonProperty("itemId")
  private Long itemId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("price")
  private Price price = null;

  @JsonProperty("quantity")
  private Long quantity = null;

  @JsonProperty("details")
  private String details = null;

  public Item category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * 
   * @return category
   **/
  @Schema(description = "")

  public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

  public Item itemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

  /**
   * Get itemId
   * 
   * @return itemId
   **/
  @Schema(description = "")

  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public Item name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * 
   * @return name
   **/
  @Schema(required = true, description = "")
  @NotNull

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Item price(Price price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * 
   * @return price
   **/
  @Schema(required = true, description = "")
  @NotNull

  @Valid
  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public Item quantity(Long quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * 
   * @return quantity
   **/
  @Schema(required = true, description = "")
  @NotNull

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  public Item details(String details) {
    this.details = details;
    return this;
  }

  /**
   * Get details
   * 
   * @return details
   **/
  @Schema(description = "")

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(this.category, item.category) &&
        Objects.equals(this.itemId, item.itemId) &&
        Objects.equals(this.name, item.name) &&
        Objects.equals(this.price, item.price) &&
        Objects.equals(this.quantity, item.quantity) &&
        Objects.equals(this.details, item.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, itemId, name, price, quantity, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Item {\n");

    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
