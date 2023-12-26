package io.swagger.Discount;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

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

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
