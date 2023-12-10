package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Discount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-10T17:52:19.390156+02:00[Europe/Vilnius]")


public class Discount   {
  @JsonProperty("discountId")
  private Long discountId = null;

  @JsonProperty("percentage")
  private Float percentage = null;

  public Discount discountId(Long discountId) {
    this.discountId = discountId;
    return this;
  }

  /**
   * Get discountId
   * @return discountId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Long getDiscountId() {
    return discountId;
  }

  public void setDiscountId(Long discountId) {
    this.discountId = discountId;
  }

  public Discount percentage(Float percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Get percentage
   * @return percentage
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Float getPercentage() {
    return percentage;
  }

  public void setPercentage(Float percentage) {
    this.percentage = percentage;
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
        Objects.equals(this.percentage, discount.percentage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(discountId, percentage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Discount {\n");
    
    sb.append("    discountId: ").append(toIndentedString(discountId)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
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
