package io.swagger.Discount;

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

public class CreateDiscount {

    @JsonProperty("discountId")
    private Long discountId = null;

    @JsonProperty("code")
    private String code = null;

    @JsonProperty("discount")
    private Float discount = null;

    @JsonProperty("tenant")
    private Long tenant = null;

    public CreateDiscount discountId(Long discountId) {
        this.discountId = discountId;
        return this;
    }

    @Schema(required = true, description = "")
    @NotNull

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public CreateDiscount code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get code
     * 
     * @return code
     **/
    @Schema(description = "")

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CreateDiscount discount(Float discount) {
        this.discount = discount;
        return this;
    }

    /**
     * Get discount
     * 
     * @return discount
     **/
    @Schema(required = true, description = "")
    @NotNull

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateDiscount discount = (CreateDiscount) o;
        return Objects.equals(this.discountId, discount.discountId) &&
                Objects.equals(this.code, discount.code) &&
                Objects.equals(this.discount, discount.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountId, code, discount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Discount {\n");

        sb.append("    discountId: ").append(toIndentedString(discountId)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
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
