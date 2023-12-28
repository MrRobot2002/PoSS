package com.vu.localhost.poss.discount.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

@Validated
public class DiscountRequestDTO {

    @JsonProperty("discountId")
    private Long discountId = null;

    @JsonProperty("code")
    private String code = null;

    @JsonProperty("discount")
    private Float discount = null;

    @JsonProperty("tenantId")
    private Long tenantId = null;

    public DiscountRequestDTO discountId(Long discountId) {
        this.discountId = discountId;
        return this;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public DiscountRequestDTO code(String code) {
        this.code = code;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DiscountRequestDTO discount(Float discount) {
        this.discount = discount;
        return this;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public DiscountRequestDTO tenantId(Long tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiscountRequestDTO discount = (DiscountRequestDTO) o;
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
        sb.append("class discount {\n");

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
